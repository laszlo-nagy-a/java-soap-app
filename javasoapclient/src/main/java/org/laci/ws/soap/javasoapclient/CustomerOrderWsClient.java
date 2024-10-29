package org.laci.ws.soap.javasoapclient;

import org.laci.ws.soap.trainings.*;
import org.laci.ws.soap.wsdlfirstws.CustomerOrdersWsImplService;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;

public class CustomerOrderWsClient {

    public static void main(String []args) {
        try {
            // kliens előkészíése
            URL url = new URL("http://localhost:8080/wsdlfirstws/customerordersservice?wsdl");
            CustomerOrdersWsImplService service = new CustomerOrdersWsImplService(url);
            CustomerOrdersPortType portType = service.getCustomerOrdersWsImplPort();

            // order készítése
            CreateOrdersRequest createOrdersRequest = new CreateOrdersRequest();
            createOrdersRequest.setCustomerId(BigInteger.valueOf(1));

            Order newOrder = new Order();
            newOrder.setId(2);

            Product newProduct = new Product();
            newProduct.setId("2");
            newProduct.setDescription("Playstation5");
            newProduct.setQuantity(BigInteger.valueOf(2));

            newOrder.getProduct().add(newProduct);

            createOrdersRequest.setOrder(newOrder);
            portType.createOrders(createOrdersRequest);

            // order lekérdezése
            GetOrdersRequest request = new GetOrdersRequest();
            request.setCustomerId(BigInteger.valueOf(1));
            GetOrdersResponse response = portType.getOrders(request);

            // termékek kiíratása
            for(Order order : response.getOrder()) {
                for(Product product : order.getProduct()) {
                    System.out.println(product.getDescription());
                }
            }
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
