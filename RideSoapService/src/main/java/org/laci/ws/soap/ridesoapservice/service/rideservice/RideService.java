package org.laci.ws.soap.ridesoapservice.service.rideservice;

import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import org.laci.ws.soap.ridesoapservice.service.rideservice.request.RideServiceRequest;
import org.laci.ws.soap.ridesoapservice.service.rideservice.response.RideServiceResponse;

@WebService
public interface RideService {
    public @WebResult(name = "rideServiceResponse") RideServiceResponse getRide (@WebParam(name = "rideServiceRequest")RideServiceRequest rideServiceRequest);

}
