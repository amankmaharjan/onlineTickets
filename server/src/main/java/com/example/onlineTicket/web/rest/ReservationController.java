//package com.example.onlineTicket.web.rest;
//
//import com.example.onlineTicket.service.ReservationService;
//import com.example.onlineTicket.web.rest.dto.ReservationInputDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * Created by aman on 7/9/17.
// */
//@RestController
//public class ReservationController {
//    @Autowired
//    ReservationService reservationService;
//
//    @PostMapping(path = "/reservation/")
//    public ResponseEntity<?> insert(@RequestBody ReservationInputDTO reservationInputDTO) {
//        reservationService.insert(reservationInputDTO);
////        System.out.println(reservationInputDTO);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
//
//    @GetMapping(path = "/reservation/")
//    public ResponseEntity<?> getAll() {
//        return new ResponseEntity<>(reservationService.findAll(), HttpStatus.OK);
//    }
//
//}
