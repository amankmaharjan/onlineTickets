package com.example.onlineTicket.service;

import com.example.onlineTicket.domain.Facility;
import com.example.onlineTicket.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FacilityService {
    @Autowired
    FacilityRepository facilityRepository;

    public Facility insert(Facility facility) {
        return facilityRepository.save(facility);
    }

    public Facility update(Facility updatedFacility) {
        Facility facility = findOneService(updatedFacility.getId());
        if (facility != null) {
            facility.setServiceType(updatedFacility.getServiceType());
            return facilityRepository.save(facility);
        }
        return null;
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

    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    public List<Facility> findByServiceType(String serviceType) {
        return facilityRepository.findByServiceType(serviceType);
    }


}
