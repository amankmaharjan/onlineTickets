package com.example.onlineTicket.web.dto;

import com.example.onlineTicket.domain.*;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
public class ReservationDTO {

    private String id;

    private Seat seat;

    private Schedule schedule;

    private Passenger passenger;

    private Route route;

    public ReservationDTO(Reservation reservation) {
        this.id = reservation.getId();
        this.seat = reservation.getSeat();
        this.schedule = reservation.getSchedule();
        this.passenger = reservation.getPassenger();
        this.route = reservation.getRoute();
    }
}
