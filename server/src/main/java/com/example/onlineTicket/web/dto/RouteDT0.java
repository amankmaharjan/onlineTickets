package com.example.onlineTicket.web.dto;

import com.example.onlineTicket.domain.Route;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
public class RouteDT0 {
    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private String source;
    @Getter
    @Setter
    private String destination;
    @Getter
    @Setter
    private Integer fare;

    public RouteDT0(Route route) {
        this.id = route.getId();
        this.source =route.getSource();
        this.destination = route.getDestination();
        this.fare = route.getFare();
    }
}
