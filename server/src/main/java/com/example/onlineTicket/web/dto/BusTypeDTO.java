package com.example.onlineTicket.web.dto;

import com.example.onlineTicket.domain.BusType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
public class BusTypeDTO {
    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private String busType;

    public BusTypeDTO(BusType busType) {
        this.id = busType.getId();
        this.busType = busType.getBusType();
    }
}
