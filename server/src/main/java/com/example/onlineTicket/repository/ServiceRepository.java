package com.example.onlineTicket.repository;

import com.example.onlineTicket.domain.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
}
