package com.example.onlineTicket.service;

import com.example.onlineTicket.domain.BusType;
import com.example.onlineTicket.repository.BusTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by aman on 7/9/17.
 */
@Service
@Transactional
public class BusTypeService {
    @Autowired
    BusTypeRepository busTypeRepository;

    public BusType insert(BusType busType) {
        return busTypeRepository.save(busType);

    }

    public void update(String id, BusType busType) {
        BusType updatedbusType = findOne(id);
        if (updatedbusType != null) {
            updatedbusType.setBusType(busType.getBusType());
            busTypeRepository.save(updatedbusType);
        }
    }

    public void delete(String id) {
        BusType busType = findOne(id);
        if (busType != null) {
            busTypeRepository.delete(id);
        }
    }

    public List<BusType> findAll() {
        return busTypeRepository.findAll();
    }

    public BusType findOne(String id) {
        return busTypeRepository.findOne(id);
    }
}

