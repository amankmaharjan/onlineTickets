package com.example.onlineTicket.web.rest;

import com.example.onlineTicket.domain.Reservation;
import com.example.onlineTicket.service.ReservationService;
import com.example.onlineTicket.web.dto.ReservationDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aman on 7/9/17.
 */
@RestController
public class ReservationController {
    @Autowired
    ReservationService reservationService;
    @Autowired
    ModelMapper modelMapper;

    @PostMapping(path = "/reservation/")
    public ResponseEntity<?> insert(@RequestBody ReservationDTO reservationDTO) {
        Reservation reservation = convertToReservation(reservationDTO);
        Reservation currentReservation = reservationService.insert(reservation);
        return new ResponseEntity<>(currentReservation, HttpStatus.CREATED);
    }

    private Reservation convertToReservation(ReservationDTO reservationDTO) {
        Reservation reservation = modelMapper.map(reservationDTO, Reservation.class);
        return reservation;
    }

    @GetMapping(path = "/reservation/")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(reservationService.findAll(), HttpStatus.OK);
    }
}
