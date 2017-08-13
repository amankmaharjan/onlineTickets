package com.example.onlineTicket.web.rest;

import com.example.onlineTicket.domain.Seat;
import com.example.onlineTicket.service.SeatService;
import com.example.onlineTicket.web.dto.SeatDTO;
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
public class SeatController {
    @Autowired
    SeatService seatService;
    @Autowired
    ModelMapper modelMapper;

    @PostMapping(path = "/seat/")
    public ResponseEntity<?> insert(@RequestBody SeatDTO seatDTO
    ) {
        Seat seat = convertToSeat(seatDTO);
        seatService.insert(seat);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    private Seat convertToSeat(SeatDTO seatDTO) {
        Seat seat = modelMapper.map(seatDTO,Seat.class);
        return seat;
    }

    @GetMapping(path = "/seat/")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(seatService.findAll(), HttpStatus.OK);
    }

}
