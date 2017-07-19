package com.example.onlineTicket.repository;

import com.example.onlineTicket.domain.Route;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by aman on 7/9/17.
 */
public interface RouteRepository extends JpaRepository<Route, String> {
    public Route findBysourceAndDestination(String source, String destination);
}
