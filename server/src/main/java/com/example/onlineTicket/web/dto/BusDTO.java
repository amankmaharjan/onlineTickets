package com.example.onlineTicket.web.dto;

import com.example.onlineTicket.domain.Bus;
import com.example.onlineTicket.domain.BusType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@ToString
public class BusDTO {
    @Getter
    @Setter
    private String no;
    @Getter
    @Setter
    private Integer seatRow;
    @Getter
    @Setter
    private Integer seatColumn;
    @Getter
    @Setter
    private BusType bus_type;
    @Getter
    @Setter
    private java.util.Set schedule;
    @Getter
    @Setter
    private java.util.Set facility;
    @Getter
    @Setter
    private java.util.Set seat;

    public BusDTO(Bus bus) {
        this.no = bus.getNo();
        this.seatRow = bus.getSeatRow();
        this.seatColumn = bus.getSeatColumn();
        this.bus_type = bus.getBus_type();
        this.schedule = bus.getSchedule();
        this.facility = bus.getFacility();
        this.seat = bus.getSeat();
    }

}
