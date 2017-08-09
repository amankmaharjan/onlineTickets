package com.example.onlineTicket.repository;

import com.example.onlineTicket.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,String>{
}
