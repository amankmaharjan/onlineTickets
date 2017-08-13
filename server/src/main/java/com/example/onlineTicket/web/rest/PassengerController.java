package com.example.onlineTicket.web.rest;

import com.example.onlineTicket.domain.Passenger;
import com.example.onlineTicket.service.PassengerService;
import com.example.onlineTicket.web.dto.PassengerDTO;
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
public class PassengerController {
    @Autowired
    PassengerService passengerService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(path = "/passenger/")
    public ResponseEntity<?> insert(@RequestBody PassengerDTO passengerDTO) {
        Passenger passenger = convertToPassenger(passengerDTO);
        passengerService.insert(passenger);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/passenger/")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(passengerService.findAll(), HttpStatus.OK);
    }

    private Passenger convertToPassenger(PassengerDTO passengerDTO) {
        Passenger passenger = modelMapper.map(passengerDTO, Passenger.class);
        return passenger;
    }
}
