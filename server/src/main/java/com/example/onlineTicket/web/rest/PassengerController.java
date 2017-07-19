package com.example.onlineTicket.web.rest;

import com.example.onlineTicket.domain.Passenger;
import com.example.onlineTicket.service.PassengerService;
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

    @PostMapping(path = "/passenger/")
    public ResponseEntity<?> insert(@RequestBody Passenger passenger) {
        passengerService.insert(passenger);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/passenger/")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(passengerService.findAll(), HttpStatus.OK);
    }

}
