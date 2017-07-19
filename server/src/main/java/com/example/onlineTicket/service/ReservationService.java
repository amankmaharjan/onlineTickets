//package com.example.onlineTicket.service;
//
//import com.example.onlineTicket.domain.*;
//import com.example.onlineTicket.repository.*;
//import com.example.onlineTicket.web.rest.dto.ReservationInputDTO;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.awt.print.Book;
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * Created by aman on 7/9/17.
// */
//@RestController
//public class ReservationService {
//    private final Logger log = LoggerFactory.getLogger(ReservationService.class);
//
//    @Autowired
//    ReservationRepository reservationRepository;
//    @Autowired
//    RouteRepository routeRepository;
//    @Autowired
//    BusRepository busRepository;
//    Boolean statusChecker = false;//indicates seat availability false =not available
//    @Autowired
//    SeatRepository seatRepository;
//    @Autowired
//    BusTimeRepository busTimeRepository;
//    Reservation reservation;
//
//
//    public void insert(ReservationInputDTO reservationInputDTO) {
//        Bus bus;
//        Route route;
//        BusTime busTime;
//        int fare = 500;
//        List<Seat> bookableSeatList = new LinkedList<>();
//        reservation = new Reservation();
//
//
//        //  log.info(reservationInputDTO.getSeatIds().toString());
//        reservationChecker(reservationInputDTO, bookableSeatList);
//        //bookableSeatList.forEach(System.out::println);
//
//        //log.info(statusChecker.toString());
//        //add entry in reservation
//        if (statusChecker) {
//
//            route = routeRepository.findOne(reservationInputDTO.getRouteId());
//            bus = busRepository.findOne(Integer.parseInt(reservationInputDTO.getBusNo()));
//            busTime = busTimeRepository.findOne(reservationInputDTO.getBusTimeId());
//
//            reservation.setRoute(route);
//            reservation.setBus(bus);
//            reservation.setBusTime(busTime);
//            reservation.setFare(fare);
//            reservation.setSeatList(bookableSeatList);
//            //  log.info("reservation");
//            //log.info(reservation.toString());
//            reservationRepository.save(reservation);
//
//        } else {
//            log.info("no seat available");
//        }
//    }
//
//    public Boolean reservationChecker(ReservationInputDTO reservationInputDTO, List<Seat> bookableSeatList) {
//        //checking if seat is booked or not, if not it will book
//        outerloop:
//        for (Seat seat : seatRepository.findAll()
//                ) {
//            for (String bookable : reservationInputDTO.getSeatIds()
//                    ) {
//                if (seat.getSeatId().equals(bookable)) {
//                    System.out.println(seat + "found ");
//                    if (seat.getStatus() == true) {
//                        statusChecker = false;
//                        break outerloop;
//                    }
//                    seat.setStatus(true);
//                    bookableSeatList.add(seat); //booking seats
//                    statusChecker = true;
//                }
//            }
//        }
//        return statusChecker;
//    }
//
//    public List<Reservation> findAll() {
//        return reservationRepository.findAll();
//    }
//
//}
