package com.example.onlineTicket.service;

import com.example.onlineTicket.domain.Bus;
import com.example.onlineTicket.domain.BusType;
import com.example.onlineTicket.domain.Route;
import com.example.onlineTicket.repository.BusRepository;
import com.example.onlineTicket.repository.BusTypeRepository;
import com.example.onlineTicket.repository.RouteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by aman on 7/9/17.
 */
@Service
@Transactional
public class BusService {
    private final Logger log = LoggerFactory.getLogger(BusService.class);
    @Autowired
    BusRepository busRepository;
    @Autowired
    BusTypeRepository busTypeRepository;
    @Autowired
    RouteRepository routeRepository;

    public void insert(Bus bus) {
        BusType busType = busTypeRepository.findOne(bus.getBusType().getId());
        Route route = routeRepository.findOne(bus.getRoute().getRouteId());
        bus.setBusType(busType);
        bus.setRoute(route);
        busRepository.save(bus);
    }

    public List<Bus> findAll() {
        return busRepository.findAll();
    }

    public void update(Bus editedBus) {
        Bus bus = findOneBus(editedBus.getBusNo());
        if (bus != null) {
            bus.setBusNo(editedBus.getBusNo());
            bus.setServices(editedBus.getServices());
            busRepository.save(bus);
        }
    }

    public Bus findOneBus(String busNo) {
        return busRepository.findOne(busNo);
    }

    public void delete(String busNo) {
        Bus bus = findOneBus(busNo);
        if (bus != null) {
            busRepository.delete(bus);
        }

    }

    public List<Bus> findByRouteSourceAndDestination(Route route) {

        Route busRoute = routeRepository.findBysourceAndDestination(route.getSource(), route.getDestination());
        System.out.println(busRoute.toString());
        if (busRoute != null) {
            return busRepository.findBusesByRoute(busRoute);
        }
        return null;
    }
}
