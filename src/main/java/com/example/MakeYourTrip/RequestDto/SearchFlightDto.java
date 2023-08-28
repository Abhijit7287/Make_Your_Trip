package com.example.MakeYourTrip.RequestDto;

import com.example.MakeYourTrip.Enums.City;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SearchFlightDto {

    private City fromCity;
    private City toCity;
    private LocalDate journeyDate;
}
