package org.laci.ws.soap.ridesoapservice.service.rideservice;

import org.laci.ws.soap.ridesoapservice.service.rideservice.request.RideServiceRequest;
import org.laci.ws.soap.ridesoapservice.service.rideservice.response.RideServiceResponse;

public class RideServiceImpl implements RideService {
    @Override
    public RideServiceResponse getRide(RideServiceRequest rideServiceRequest) {
        RideServiceResponse response = new RideServiceResponse();
        response.setResult(true);
        return response;
    }
}
