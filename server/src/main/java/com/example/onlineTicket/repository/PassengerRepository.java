package com.example.onlineTicket.repository;

import com.example.onlineTicket.domain.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.net.PasswordAuthentication;

/**
 * Created by aman on 7/9/17.
 */
public interface PassengerRepository extends JpaRepository<Passenger, String> {
}
