package com.example.onlineTicket.repository;

import com.example.onlineTicket.domain.Bus;
import com.example.onlineTicket.domain.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by aman on 7/9/17.
 */
@Repository
public interface BusRepository extends JpaRepository<Bus, String> {
    public List<Bus> findBusesByRoute(Route route);
}
