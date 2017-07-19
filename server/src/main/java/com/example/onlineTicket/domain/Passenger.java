package com.example.onlineTicket.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by aman on 7/8/17.
 */
@Entity
@NoArgsConstructor
@Table(name = "passenger")
@ToString
public class Passenger {
    @Id
    @Getter
    @Setter
    @GenericGenerator(name = "sequence_pass_id", strategy = "com.example.onlineTicket.config.generator.PassengerIdGenerator")
    @GeneratedValue(generator = "sequence_pass_id")
    @Column(name = "pass_Id")
    private
    String passengerId;
    @Getter
    @Setter
    @Column(name = "name")
    private
    String name;

    @Getter
    @Setter
    @Column(name = "gender")
    private
    Boolean gender;

    @OneToOne(cascade = CascadeType.ALL)
    @Getter
    @Setter
    private
    Contact contact;
}
