package com.example.onlineTicket.web.dto;

import com.example.onlineTicket.domain.Passenger;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
public class PassengerDTO {
    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String address;
    @Getter
    @Setter
    private Boolean gender;
    @Getter
    @Setter
    private String mobileNo;
    @Getter
    @Setter
    private String email;

    public PassengerDTO(Passenger passenger) {
        this.id = passenger.getId();
        this.name = passenger.getName();
        this.address =passenger.getAddress();
        this.gender = passenger.getGender();
        this.mobileNo = passenger.getMobileNo();
        this.email = passenger.getEmail();
    }
}
