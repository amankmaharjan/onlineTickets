package com.example.onlineTicket.web.dto;

import com.example.onlineTicket.domain.Schedule;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
public class ScheduleDTO {

    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private String date;
    @Getter
    @Setter
    private String departureTime;

    public ScheduleDTO(Schedule schedule) {
        this.id = schedule.getId();
        this.date = schedule.getDate();
        this.departureTime = schedule.getDepartureTime();
    }
}
