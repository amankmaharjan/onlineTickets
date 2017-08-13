package com.example.onlineTicket.service;

import com.example.onlineTicket.domain.Bus;
import com.example.onlineTicket.domain.Route;
import com.example.onlineTicket.repository.BusRepository;
import com.example.onlineTicket.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by aman on 7/9/17.
 */
@Service
@Transactional
public class RouteService {
    @Autowired
    RouteRepository routeRepository;

    public Route insert(Route route) {
        return routeRepository.save(route);
    }

    public Route update(String routeid, Route route) {
        Route updatedRoute = findOne(routeid);
        if (updatedRoute != null) {
            return routeRepository.save(updatedRoute);
        }
        return null;
    }

    public List<Route> findAll() {
        return routeRepository.findAll();
    }


    public void delete(String routeId) {
        Route route = findOne(routeId);
        if (route != null) {
            routeRepository.delete(routeId);
        }
    }


    public Route findOne(String routeId) {
        return routeRepository.findOne(routeId);
    }

}
