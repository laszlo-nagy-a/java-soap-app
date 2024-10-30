package org.laci.ws.soap.ridesoapservice.service.rideservice.response;

import jakarta.xml.bind.annotation.XmlType;

@XmlType
public class RideServiceResponse {
    private boolean result;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
