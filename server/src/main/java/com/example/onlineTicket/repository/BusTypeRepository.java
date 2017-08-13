package com.example.onlineTicket.repository;

import com.example.onlineTicket.domain.BusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusTypeRepository extends JpaRepository<BusType, String> {
}
