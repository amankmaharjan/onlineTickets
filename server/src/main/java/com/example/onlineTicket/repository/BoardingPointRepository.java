package com.example.onlineTicket.repository;

import com.example.onlineTicket.domain.BoardingPoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardingPointRepository extends JpaRepository<BoardingPoint,String> {
}
