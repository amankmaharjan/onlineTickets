package com.example.onlineTicket.repository;

import com.example.onlineTicket.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by aman on 7/9/17.
 */
public interface ContactRepository extends JpaRepository<Contact,Integer> {
}
