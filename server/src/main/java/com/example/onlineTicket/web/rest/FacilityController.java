package com.example.onlineTicket.web.rest;

import com.example.onlineTicket.domain.Facility;
import com.example.onlineTicket.service.FacilityService;
import com.example.onlineTicket.web.dto.FacilityDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FacilityController {
    @Autowired
    FacilityService facilityService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(path = "/facility/")
    public ResponseEntity<?> insert(@RequestBody FacilityDTO facilityDTO) {
        Facility facility = convertToFacility(facilityDTO);
        facilityService.insert(facility);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/facility/")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(facilityService.findAll(), HttpStatus.OK);
    }

    private Facility convertToFacility(FacilityDTO facilityDTO) {
        Facility facility = modelMapper.map(facilityDTO, Facility.class);
        return facility;
    }
}
