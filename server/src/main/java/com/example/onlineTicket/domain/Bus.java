package com.example.onlineTicket.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Created by aman on 7/8/17.
 */
@Entity
@NoArgsConstructor
@Table(name = "bus")
@ToString
public class Bus {
    @Id
    @Column(name = "bus_no")
    @Getter
    @Setter
    private
    String busNo;

    @Column(name = "bus_name")
    @Getter
    @Setter
    private
    String busName;

    @Getter
    @Setter
    @ManyToOne(cascade = CascadeType.PERSIST)
    private
    BusType busType;

    @Getter
    @Setter
    @Column(name = "services")
    private
    String services;

    @Getter
    @Setter
    private
    @Column(name = "departureTime")
    String departureTime;

    @Getter
    @Setter
    @OneToMany(cascade = CascadeType.PERSIST)
    private
    List<Seat> seatList;

    @Getter
    @Setter
    @ManyToOne(cascade = CascadeType.PERSIST)
    private
    Route route;
}

