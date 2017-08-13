package com.example.onlineTicket.service;

import com.example.onlineTicket.domain.Facility;
import com.example.onlineTicket.web.dto.FacilityDTO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)

public class BusServiceFacilityTest {
    @Autowired
    private FacilityService facilityService;
    private FacilityDTO facilityDTO;
    private Facility facility;

    @Before
    public void setUp() throws Exception {
        facility = new Facility();
        facility.setServiceType("ac");
        facilityDTO = new FacilityDTO(facility);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() throws Exception {
        Assert.assertNotNull(facilityService.insert(facility));
    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void findOneService() throws Exception {
    }

    @Test
    public void findAll() throws Exception {
        Assert.assertNotNull(facilityService.findAll());
    }

    @Test
    public void findByServiceType() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

}