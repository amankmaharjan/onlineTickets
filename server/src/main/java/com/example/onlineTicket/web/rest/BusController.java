package com.example.onlineTicket.web.rest;

import com.example.onlineTicket.domain.Bus;
import com.example.onlineTicket.domain.Route;
import com.example.onlineTicket.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by aman on 7/9/17.
 */
@RestController
public class BusController {
    @Autowired
    BusService busService;



    @PostMapping(path = "/bus/")
    public ResponseEntity<?> insert(@RequestBody Bus bus) {
        busService.insert(bus);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/bus/")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(busService.findAll(), HttpStatus.OK);
    }

    @PutMapping(path = "/bus/")
    public ResponseEntity<?> update(@RequestBody Bus bus) {
        busService.update(bus);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/bus/{busNo}")
    public ResponseEntity<?> delete(@PathVariable String busNo) {
        busService.delete(busNo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/bus/route/")
    public ResponseEntity<?> getBusesByRoute(@RequestBody Route route) {
        return new ResponseEntity<>(busService.findByRouteSourceAndDestination(route), HttpStatus.OK);
    }
    @GetMapping(path = "/bus/{busNo}")
    public ResponseEntity<?> getBus(@PathVariable String busNo) {
        return new ResponseEntity<>(busService.findOneBus(busNo), HttpStatus.OK);
    }


}
