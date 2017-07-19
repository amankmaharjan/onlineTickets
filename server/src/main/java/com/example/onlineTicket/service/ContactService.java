package com.example.onlineTicket.service;

import com.example.onlineTicket.domain.Contact;
import com.example.onlineTicket.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by aman on 7/9/17.
 */
@Service
@Transactional
public class ContactService {
    @Autowired
    ContactRepository contactRepository;

    public void insert(Contact contact) {
        contactRepository.save(contact);
    }

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

}
