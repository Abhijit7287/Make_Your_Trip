package com.example.MakeYourTrip.ResponceDtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class FlightResult {

    private LocalDate journeyDate;
    private LocalTime startTime;
    private double journeyTime;
    private String companyName;
    private String listOfStopInBetween;
}
