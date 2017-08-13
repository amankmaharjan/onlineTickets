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


    public Passenger insert(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Passenger update(String id, Passenger updatedPassenger) {
        Passenger passenger = findOne(id);
        if (passenger != null) {
            passenger.setName(updatedPassenger.getName());
            passenger.setMobileNo(updatedPassenger.getMobileNo());
            passenger.setAddress(updatedPassenger.getAddress());
            passenger.setGender(updatedPassenger.getGender());
            passenger.setEmail(updatedPassenger.getEmail());
            passenger.setBoarding_point(updatedPassenger.getBoarding_point());
            return passengerRepository.save(passenger);
        }
        return null;
    }

    public void delete(String id) {
        Passenger passenger = findOne(id);
        if (passenger != null) {
            passengerRepository.delete(id);
        }
    }

    public Passenger findOne(String id) {
        return passengerRepository.findOne(id);
    }

    public List<Passenger> findAll() {
        return passengerRepository.findAll();
    }


}
