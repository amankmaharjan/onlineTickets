package com.example.onlineTicket.web.dto;

import com.example.onlineTicket.domain.Seat;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class SeatDTO {
    private String id;

    private String seatName;

    private Integer seatMapValueX;

    private Integer seatMapValueY;

    public SeatDTO(Seat seat) {
        this.id = seat.getId();
        this.seatName = seat.getSeatName();
        this.seatMapValueX = seat.getSeatMapValueX();
        this.seatMapValueY = seat.getSeatMapValueY();
    }
}
