package com.example.onlineTicket.web.rest;

import com.example.onlineTicket.domain.Route;
import com.example.onlineTicket.service.RouteService;
import com.example.onlineTicket.web.dto.RouteDT0;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by aman on 7/9/17.
 */
@RestController
public class RouteController {
    @Autowired
    RouteService routeService;
    @Autowired
    ModelMapper modelMapper;

    @PostMapping(path = "/route/")
    public ResponseEntity<?> insert(@RequestBody RouteDT0 routeDT0) {
        Route route = convertToRoute(routeDT0);
        routeService.insert(route);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/route/")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(routeService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/route/{routeId}")
    public ResponseEntity<?> delete(@PathVariable String routeId) {
        routeService.delete(routeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/route/{routeId")
    public ResponseEntity<?> update(@PathVariable String routeId, @RequestBody Route route) {
        routeService.update(routeId, route);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private Route convertToRoute(RouteDT0 routeDT0) {
        Route route = modelMapper.map(routeDT0, Route.class);
        return route;
    }
}
