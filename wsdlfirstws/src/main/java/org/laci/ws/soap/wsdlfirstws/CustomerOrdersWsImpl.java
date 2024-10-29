package org.laci.ws.soap.wsdlfirstws;

import org.apache.cxf.feature.Features;
import org.laci.ws.soap.trainings.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// feature engedélyezi, hogy logolódjanak a requestek és responsok a console-ra
@Features(features="org.apache.cxf.feature.LoggingFeature")
public class CustomerOrdersWsImpl implements CustomerOrdersPortType{

    private Map<BigInteger, List<Order>> customerOrders = new HashMap<>();
    private int customerId;

    public CustomerOrdersWsImpl() {
        init();
    }

    public void init() {
        List<Order> orders = new ArrayList<>();
        Order order = new Order();
        order.setId(1);

        Product product = new Product();
        product.setId("1");
        product.setDescription("IPhone");
        product.setQuantity(BigInteger.valueOf(3));
        order.getProduct().add(product);

        orders.add(order);

        customerOrders.put(BigInteger.valueOf(++customerId), orders);

    }



    @Override
    public GetOrdersResponse getOrders(GetOrdersRequest request) {
        BigInteger customerId = request.getCustomerId();
        List<Order> orders = customerOrders.get(customerId);

        GetOrdersResponse response = new GetOrdersResponse();
        response.getOrder().addAll(orders);

        return response;
    }

    @Override
    public CreateOrdersResponse createOrders(CreateOrdersRequest request) {
        BigInteger customerId = request.getCustomerId();
        Order order = request.getOrder();

         List<Order> orders = customerOrders.get(customerId);
         orders.add(order);

         CreateOrdersResponse response = new CreateOrdersResponse();
         response.setResult(true);

         return response;
    }

    @Override
    public DeleteOrderResponse deleteOrders(DeleteOrderRequest request) {
        BigInteger customerId = request.getCustomerId();
        DeleteOrderResponse deleteOrderResponse = new DeleteOrderResponse();

        if(customerId.longValueExact() <= 0) {
            deleteOrderResponse.setResult(false);
            return deleteOrderResponse;
        }

        List<Order> orders = customerOrders.get(customerId);
        Order orderToDelete = orders.get((request.getOrder().intValue()-1));
        deleteOrderResponse.setResult(orders.remove(orderToDelete));

        return deleteOrderResponse;
    }

}
