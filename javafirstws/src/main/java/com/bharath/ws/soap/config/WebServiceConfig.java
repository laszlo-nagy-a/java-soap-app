package com.bharath.ws.soap.config;

import com.bharath.ws.soap.PaymentProcessorImpl;
import jakarta.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.wss4j.common.ConfigurationConstants;
import org.apache.wss4j.dom.WSConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new PaymentProcessorImpl());
        endpoint.publish("/paymentProcessor");

        Map<String, Object> inProperties = new HashMap<>();
        // bejövő üzeneteket kapja el a security layer

        // beállítja, hogy milyen műveletre mit várjon
        inProperties.put(ConfigurationConstants.ACTION, ConfigurationConstants.USERNAME_TOKEN);
        // beállítja, hogy milyen típusú pw fog kelleni az ACTION requestekhez
        inProperties.put(ConfigurationConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
        // beállít egy jelszót, ha megfelelő felhasználó próbálja elérni a végpontot
        inProperties.put(ConfigurationConstants.PW_CALLBACK_CLASS, UTPasswordCallBack.class.getName());

        // interceptor létrehozása konfig alapján
        WSS4JInInterceptor wssIn = new WSS4JInInterceptor(inProperties);
        // végpont levédése adott interceptorral
        endpoint.getInInterceptors().add(wssIn);
        return endpoint;
    }
}