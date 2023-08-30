package com.example.MakeYourTrip.RequestDto;

import com.example.MakeYourTrip.Enums.ModeOfTransport;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AddTransport {

    private ModeOfTransport modeOfTransport;

    private LocalDate journeyDate;

    private LocalTime startTime;

    private double journeyTime;

    private Integer routeId;

    private String companyName;
}
