package com.example.onlineTicket.service;

import com.example.onlineTicket.domain.*;
import com.example.onlineTicket.repository.*;
import com.example.onlineTicket.web.rest.dto.ReservationInputDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by aman on 7/9/17.
 */
@RestController
public class ReservationService {
    private final Logger log = LoggerFactory.getLogger(ReservationService.class);

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    RouteRepository routeRepository;
    @Autowired
    BusRepository busRepository;
    Boolean statusChecker = false;//indicates seat availability false =not available
    @Autowired
    SeatRepository seatRepository;


    public Reservation insert(Reservation reservation) {
        Bus bus;
        List<Seat> bookableSeatList = new LinkedList<>();

        reservationChecker(reservation, bookableSeatList);
        //add entry in reservation
        if (statusChecker) {

            bus = busRepository.findOne((reservation.getBus().getBusNo()));
            reservation.setBus(bus);
            reservation.setSeatList(bookableSeatList);
            log.info("reservation");
            log.info(reservation.toString());
            reservationRepository.save(reservation);
            return reservation;

        } else {
            log.info("no seat available");
        }
        return null;
    }

    public Boolean reservationChecker(Reservation reservation, List<Seat> bookableSeatList) {
        //checking if seat is booked or not, if not it will book
        outerloop:
        for (Seat seat : busRepository.findOne(reservation.getBus().getBusNo()).getSeatList()) {
            for (Seat bookable : reservation.getSeatList()) {
                if (seat.getSeatId().equals(bookable.getSeatId())) {
                    System.out.println(seat + "found ");
                    if (seat.getStatus() == true) {
                        statusChecker = false;
                        break outerloop;
                    }
                    seat.setStatus(true);
                    bookableSeatList.add(seat); //booking seats
                    statusChecker = true;
                }
            }
        }
        return statusChecker;
    }

    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

}
