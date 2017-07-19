package com.example.onlineTicket.repository;

import com.example.onlineTicket.domain.BusType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by aman on 7/9/17.
 */
public interface BusTypeRepository extends JpaRepository<BusType, Integer> {
}
