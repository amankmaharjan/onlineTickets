package com.example.onlineTicket.service;

import com.example.onlineTicket.domain.Seat;
import com.example.onlineTicket.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by aman on 7/9/17.
 */
@Service
@Transactional
public class SeatService {
    @Autowired
    SeatRepository seatRepository;

    public void insert(Seat seat) {
        seatRepository.save(seat);
    }

    public List<Seat> findAll() {
        return seatRepository.findAll();
    }


}
