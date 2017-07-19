package com.example.onlineTicket.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by aman on 7/8/17.
 */
@Entity
@NoArgsConstructor
@Table(name = "seat")
@ToString
public class Seat {
    @Id
    @Getter
    @Setter
    @Column(name = "seat_id")

    @GenericGenerator(name = "sequence_seat_id", strategy = "com.example.onlineTicket.config.generator.SeatIdGenerator")
    @GeneratedValue(generator = "sequence_seat_id")
    String seatId;
    @Getter
    @Setter
    @Column(name = "seat_name")
    private
    String seatName;

    @Getter
    @Setter
    @Column(name = "status")
    private
    Boolean status;
}
