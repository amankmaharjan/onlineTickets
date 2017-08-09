package com.example.onlineTicket.web;

import com.example.onlineTicket.domain.Service;
import lombok.ToString;

@ToString
public class ServiceDto {
    int id;
    private String serviceType;

    public ServiceDto(Service service) {
        this.id=service.getId();
        this.serviceType=service.getServiceType();
    }

}
