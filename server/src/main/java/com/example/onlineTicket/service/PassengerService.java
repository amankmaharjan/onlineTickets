package com.example.onlineTicket.service;

import com.example.onlineTicket.domain.Passenger;
import com.example.onlineTicket.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by aman on 7/9/17.
 */
@Service
@Transactional
public class PassengerService {
    @Autowired
    PassengerRepository passengerRepository;

    public void insert(Passenger passenger) {
        passengerRepository.save(passenger);
    }

    public List<Passenger> findAll() {
        return passengerRepository.findAll();
    }

}
