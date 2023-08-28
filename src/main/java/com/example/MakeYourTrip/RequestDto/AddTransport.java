package com.example.MakeYourTrip.RequestDto;

import com.example.MakeYourTrip.Enums.ModeofTransport;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AddTransport {

    private ModeofTransport modeofTransport;

    private LocalDate Journydate;

    private LocalTime startTime;

    private double JourneyTime;

    private Integer routeId;

    private String companyName;
}
