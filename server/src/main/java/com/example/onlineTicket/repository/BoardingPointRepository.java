package com.example.onlineTicket.repository;

import com.example.onlineTicket.domain.BoardingPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardingPointRepository extends JpaRepository<BoardingPoint, String> {
}
