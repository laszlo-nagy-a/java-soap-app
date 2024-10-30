package org.laci.ws.soap.ridesoapservice.config;

import jakarta.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.laci.ws.soap.ridesoapservice.service.rideservice.RideServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;
    @Bean
    public Endpoint endpoint() {
        Endpoint endpoint = new EndpointImpl(bus, new RideServiceImpl());
        endpoint.publish("/rideService");
        return endpoint;
    }
}