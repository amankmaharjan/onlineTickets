package com.example.onlineTicket.web.rest;

import com.example.onlineTicket.domain.Contact;
import com.example.onlineTicket.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aman on 7/9/17.
 */
@RestController
public class ContactController {
    @Autowired
    ContactService contactService;

    @PostMapping(path = "/contact/")
    public ResponseEntity<?> insert(@RequestBody Contact contact) {
        contactService.insert(contact);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/contact/")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(contactService.findAll(), HttpStatus.OK);
    }

}
