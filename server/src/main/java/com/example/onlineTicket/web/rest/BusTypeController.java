package com.example.onlineTicket.web.rest;

import com.example.onlineTicket.domain.Bus;
import com.example.onlineTicket.domain.BusType;
import com.example.onlineTicket.service.BusTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by aman on 7/9/17.
 */
@RestController
public class BusTypeController {
    @Autowired
    BusTypeService busTypeService;

    @PostMapping(path = "/bustype/")
    public ResponseEntity<?> insert(@RequestBody BusType busType) {
        busTypeService.insert(busType);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/bustype/")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(busTypeService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/bustype/{typeId}")
    public ResponseEntity<?> delete(@PathVariable("typeId") Integer typeId) {
        busTypeService.delete(typeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/bustype/{typeid}")
    public ResponseEntity<?> update(@PathVariable Integer typeid, @RequestBody BusType busType) {
        busTypeService.update(typeid, busType);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
