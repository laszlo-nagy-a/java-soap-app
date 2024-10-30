package org.laci.ws.soap.ridesoapservice.service.rideservice.request;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "RideServiceRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class RideServiceRequest {
    private int id;
    @XmlElement(required = true)
    private String from;
    @XmlElement(required = true)
    private String to;
    @XmlElement(required = true)
    private Long cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }
}
