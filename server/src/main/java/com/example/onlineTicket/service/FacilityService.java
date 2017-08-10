package com.example.onlineTicket.service;

import com.example.onlineTicket.domain.Facility;
import com.example.onlineTicket.repository.FacilityRepository;
import com.example.onlineTicket.web.FacilityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class FacilityService {
    @Autowired
    FacilityRepository facilityRepository;

    public Facility insert(FacilityDTO serviceDTO) {
        Facility facility = new Facility();
        facility.setServiceType(serviceDTO.getServiceType());
        return facilityRepository.save(facility);
    }

    public void delete(Integer id) {
        Facility facility = findOneService(id);
        if (facility != null) {
            facilityRepository.delete(facility);
        }
    }

    public Facility findOneService(Integer id) {
        return facilityRepository.findOne(id);
    }

    public List<Facility> FindAll() {
        return facilityRepository.findAll();
    }

    public List<Facility> findByServiceType(String serviceType) {
        return facilityRepository.findByServiceType(serviceType);
    }

    public void update(FacilityDTO facilityDTO) {
        Facility facility = findOneService(facilityDTO.getId());
        if (facility != null) {
            facility.setServiceType(facilityDTO.getServiceType());
            facilityRepository.save(facility);
        }
    }

}
