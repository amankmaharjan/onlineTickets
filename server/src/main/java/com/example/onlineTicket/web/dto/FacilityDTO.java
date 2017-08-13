package com.example.onlineTicket.web.dto;

import com.example.onlineTicket.domain.Facility;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class FacilityDTO {
    @Getter
    @Setter
    int id;
    @Getter
    @Setter
    private String serviceType;

    public FacilityDTO(Facility facility) {
        this.id = facility.getId();
        this.serviceType = facility.getServiceType();
    }
}
