package com.example.onlineTicket.web.rest;

import com.example.onlineTicket.domain.BusType;
import com.example.onlineTicket.service.BusTypeService;
import com.example.onlineTicket.web.dto.BusTypeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by aman on 7/9/17.
 */
@RestController
public class BusTypeController {
    @Autowired
    BusTypeService busTypeService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(path = "/bustype/")
    public ResponseEntity<?> insert(@RequestBody BusTypeDTO busTypeDTO) {
        BusType busType = convertToBusType(busTypeDTO);
        busTypeService.insert(busType);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/bustype/")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(busTypeService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/bustype/{typeId}")
    public ResponseEntity<?> delete(@PathVariable("typeId") String typeId) {
        busTypeService.delete(typeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/bustype/{typeid}")
    public ResponseEntity<?> update(@PathVariable String typeid, @RequestBody BusTypeDTO busTypeDTO) {
        BusType busType = convertToBusType(busTypeDTO);
        busTypeService.update(typeid, busType);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private BusType convertToBusType(BusTypeDTO busTypeDTO) {
        BusType busType = modelMapper.map(busTypeDTO, BusType.class);
        return busType;
    }
}
