package com.bharath.ws.soap;

import com.bharath.ws.soap.dto.PaymentProcessorRequest;
import com.bharath.ws.soap.dto.PaymentProcessorResponse;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.WebResult;
import jakarta.jws.WebParam;

// webservice megjelenik a WSDL-ben
@WebService(name = "PaymentProcessor")
public interface PaymentProcessor {

	// nem kötelező, de megejölhető, a metódus a szerizen belül (tartalmazza a @WebService annotáció)
	@WebMethod
	// @WebResult beállítható, a visszatérési érték -> output
	// @WebResponse beállítható, az paraméter érték -> input
	public @WebResult(name = "response")PaymentProcessorResponse processPayment(@WebParam(name = "paymentProcessorRequest")PaymentProcessorRequest paymentProcessorRequest);
}
