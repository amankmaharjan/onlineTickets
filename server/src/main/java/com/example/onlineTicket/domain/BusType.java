package com.example.onlineTicket.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by aman on 7/9/17.
 */
@Entity
@NoArgsConstructor
@Table(name = "bus_type")
@ToString
public class BusType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    @Column(name = "bus_typeId")
    private Integer id;
    @Getter
    @Setter
    @Column(name = "bus_type")
    private
    String type;

}
