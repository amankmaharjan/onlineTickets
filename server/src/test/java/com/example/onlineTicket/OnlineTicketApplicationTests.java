package com.example.onlineTicket;

import com.example.onlineTicket.domain.*;
import com.example.onlineTicket.repository.*;
import com.example.onlineTicket.web.ServiceDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OnlineTicketApplicationTests {

    @Autowired
    BusTypeRepository busTypeRepository;
    @Autowired
    RouteRepository routeRepository;

    @Autowired
    SeatRepository seatRepository;
    @Autowired
    ServiceRepository serviceRepository;
    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    BusRepository busRepository;
    @Autowired
    BoardingPointRepository boardingPointRepository;

    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    ReservationRepository reservationRepository;
    @Test
    public void SetBusTypes() {
        BusType busType = new BusType();
        busType.setBusType("articulated");
        busTypeRepository.save(busType);
        busTypeRepository.delete(busType);
    }

    @Test
    public void setRoutes() {
        Route route = new Route();
        route.setSource("kathmandu");
        route.setDestination("pokhara");
        route.setFare(500);
        routeRepository.save(route);
//        routeRepository.findOne(route);
        routeRepository.delete(route);
    }

    @Test
    public void setServices() {
        Service service = new Service();
        service.setServiceType("ac");
        serviceRepository.save(service);
        ServiceDto serviceDto = new ServiceDto(serviceRepository.findOne(service.getId()));
        System.out.println(serviceDto);
    }

    @Test
    public void checkSchedule() {
        Route route = new Route();
        route.setSource("kathmandu");
        route.setDestination("pokhara");
        route.setFare(500);
        Set<Route> routeSet = new HashSet<>();
        routeSet.add(route);
        routeRepository.save(routeSet);
        Schedule schedule = new Schedule();
        schedule.setDate("2017/7/8");
        schedule.setDepartureTime("8:9");
        schedule.setRoute(routeSet);
        scheduleRepository.save(schedule);
        scheduleRepository.delete(schedule);
        routeRepository.delete(routeSet);
    }


    @Test
    public void checkReservation() {
        BoardingPoint boardingPoint = new BoardingPoint();
        boardingPoint.setAddress("kathmandu");
        Set<BoardingPoint>boardingPointSet=new HashSet<>();
        boardingPointSet.add(boardingPoint);
        boardingPointRepository.save(boardingPointSet);

        Route route = new Route();
        route.setSource("kathmandu");
        route.setDestination("pokhara");
        route.setFare(500);
        route.setBoarding_point(boardingPointSet);
        Set<Route> routeSet = new HashSet<>();
        routeSet.add(route);
        routeRepository.save(routeSet);

        Schedule schedule = new Schedule();
        schedule.setDate("2017/7/8");
        schedule.setDepartureTime("8:9");
        schedule.setRoute(routeSet);
        Set<Schedule> scheduleSet = new HashSet<>();
        scheduleSet.add(schedule);
        scheduleRepository.save(scheduleSet);

        BusType busType = new BusType();
        busType.setBusType("articulated");
        busTypeRepository.save(busType);

        Service service = new Service();
        service.setServiceType("ac");
        Set<Service> serviceSet = new HashSet<>();
        serviceSet.add(service);
        serviceRepository.save(serviceSet);

        Bus bus = new Bus();
        bus.setNo("ba123");
        bus.setSeatRow(3);
        bus.setSeatColumn(3);
        bus.setBus_type(busType);
        bus.setService(serviceSet);
        bus.setSchedule(scheduleSet);
        busRepository.save(bus);

        Seat seat1 = new Seat();
        seat1.setSeatName("a1");
        seat1.setSeatMapValueX(0);
        seat1.setSeatMapValueY(1);
        seat1.setBusno(bus);

        Seat seat2 = new Seat();
        seat2.setSeatName("a2");
        seat2.setSeatMapValueX(0);
        seat2.setSeatMapValueY(2);
        seat2.setBusno(bus);

        Set<Seat> seatSet = new LinkedHashSet<>();
        seatSet.add(seat1);
        seatSet.add(seat2);
        seatRepository.save(seatSet);

        Passenger passenger=new Passenger();
        passenger.setName("aman");
        passenger.setGender(true);
        passenger.setEmail("amanht3@gmail.com");
        passenger.setAddress("manamaiju");
        passenger.setMobileNo("9849854776");
        passenger.setBoarding_point(boardingPoint);
        passengerRepository.save(passenger);


        Reservation reservation=new Reservation();
        reservation.setPassenger(passenger);
        reservation.setRoute(route);
        reservation.setSchedule(schedule);
        reservation.setSeat(seat1);
        reservationRepository.save(reservation);

    }

    @Test
    public void setSeat() {
        BoardingPoint boardingPoint = new BoardingPoint();
        boardingPoint.setAddress("kathmandu");
        Set<BoardingPoint>boardingPointSet=new HashSet<>();
        boardingPointSet.add(boardingPoint);
        boardingPointRepository.save(boardingPointSet);

        Route route = new Route();
        route.setSource("kathmandu");
        route.setDestination("pokhara");
        route.setFare(500);
        route.setBoarding_point(boardingPointSet);
        Set<Route> routeSet = new HashSet<>();
        routeSet.add(route);
        routeRepository.save(routeSet);

        Schedule schedule = new Schedule();
        schedule.setDate("2017/7/8");
        schedule.setDepartureTime("8:9");
        schedule.setRoute(routeSet);
        Set<Schedule> scheduleSet = new HashSet<>();
        scheduleSet.add(schedule);
        scheduleRepository.save(scheduleSet);

        BusType busType = new BusType();
        busType.setBusType("articulated");
        busTypeRepository.save(busType);

        Service service = new Service();
        service.setServiceType("ac");
        Set<Service> serviceSet = new HashSet<>();
        serviceSet.add(service);
        serviceRepository.save(serviceSet);

        Bus bus = new Bus();
        bus.setNo("ba123");
        bus.setSeatRow(3);
        bus.setSeatColumn(3);
        bus.setBus_type(busType);
        bus.setService(serviceSet);
        bus.setSchedule(scheduleSet);
        busRepository.save(bus);

        Seat seat1 = new Seat();
        seat1.setSeatName("a1");
        seat1.setSeatMapValueX(0);
        seat1.setSeatMapValueY(1);
        seat1.setBusno(bus);

        Seat seat2 = new Seat();
        seat2.setSeatName("a2");
        seat2.setSeatMapValueX(0);
        seat2.setSeatMapValueY(2);
        seat2.setBusno(bus);

        Set<Seat> seatSet = new LinkedHashSet<>();
        seatSet.add(seat1);
        seatSet.add(seat2);
        seatRepository.save(seatSet);
        seatRepository.delete(seatSet);
        busRepository.delete(bus);
        serviceRepository.delete(serviceSet);
        busTypeRepository.delete(busType);
        scheduleRepository.delete(scheduleSet);
        routeRepository.delete(routeSet);


    }

    @Test
    public void checkBoardingPoint() {
        BoardingPoint boardingPoint = new BoardingPoint();
        boardingPoint.setAddress("kathmandu");
        boardingPointRepository.save(boardingPoint);
        boardingPointRepository.delete(boardingPoint);

    }
    @Test
    public void checkPassenger(){
        BoardingPoint boardingPoint = new BoardingPoint();
        boardingPoint.setAddress("kathmandu");
        boardingPointRepository.save(boardingPoint);

        Passenger passenger=new Passenger();
        passenger.setName("aman");
        passenger.setGender(true);
        passenger.setEmail("amanht3@gmail.com");
        passenger.setAddress("manamaiju");
        passenger.setMobileNo("9849854776");
        passenger.setBoarding_point(boardingPoint);
        passengerRepository.save(passenger);
        passengerRepository.delete(passenger);
        boardingPointRepository.delete(boardingPoint);

    }

    @Test
    public void CheckBus() {
        BoardingPoint boardingPoint = new BoardingPoint();
        boardingPoint.setAddress("kathmandu");
        Set<BoardingPoint>boardingPointSet=new HashSet<>();
        boardingPointSet.add(boardingPoint);
        boardingPointRepository.save(boardingPointSet);

        Route route = new Route();
        route.setSource("kathmandu");
        route.setDestination("pokhara");
        route.setFare(500);
        route.setBoarding_point(boardingPointSet);
        Set<Route> routeSet = new HashSet<>();
        routeSet.add(route);
        routeRepository.save(routeSet);

        Schedule schedule = new Schedule();
        schedule.setDate("2017/7/8");
        schedule.setDepartureTime("8:9");
        schedule.setRoute(routeSet);
        Set<Schedule> scheduleSet = new HashSet<>();
        scheduleSet.add(schedule);
        scheduleRepository.save(scheduleSet);

        BusType busType = new BusType();
        busType.setBusType("articulated");
        busTypeRepository.save(busType);

        Service service = new Service();
        service.setServiceType("ac");
        Set<Service> serviceSet = new HashSet<>();
        serviceSet.add(service);
        serviceRepository.save(serviceSet);

        Bus bus = new Bus();
        bus.setNo("ba123");
        bus.setSeatRow(3);
        bus.setSeatColumn(3);
        bus.setBus_type(busType);
        bus.setService(serviceSet);
        bus.setSchedule(scheduleSet);
        busRepository.save(bus);
//        busRepository.delete(bus);
//        serviceRepository.delete(serviceSet);
//        busTypeRepository.delete(busType);
//        scheduleRepository.delete(scheduleSet);
//        routeRepository.delete(routeSet);
    }


    @Test
    public void checkReser() {
    }

}
