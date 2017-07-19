package com.example.onlineTicket.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by aman on 7/8/17.
 */
@Entity
@NoArgsConstructor
@Table(name = "contact")
@ToString
public class Contact {

    @Id
    @Getter
    @Setter
    @Column(name = "mobile_no")
    private
    Integer mobileNo;

    @Getter
    @Setter
    @Column(name = "email")
    private
    String email;

    @Getter
    @Setter
    @Column(name = "boarding_point")
    private
    String boardingPoint;

}
