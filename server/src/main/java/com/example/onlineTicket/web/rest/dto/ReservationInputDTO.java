package com.example.onlineTicket.web.rest.dto;

import com.example.onlineTicket.domain.Passenger;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by aman on 7/11/17.
 */
@ToString
@NoArgsConstructor
public class ReservationInputDTO implements Serializable{
    @Getter
    @Setter
    int fare;
    @Getter
    @Setter
    String ticketId;
    @Getter
    @Setter
    Passenger passenger;
    @Getter
    @Setter
    String routeId;
    @Getter
    @Setter
    String busNo;
    @Getter
    @Setter
    List<String> seatIds;
    @Getter
    @Setter
    String busTimeId;


}