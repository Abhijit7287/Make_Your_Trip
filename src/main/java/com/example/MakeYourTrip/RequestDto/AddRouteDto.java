package com.example.MakeYourTrip.RequestDto;

import com.example.MakeYourTrip.Enums.City;
import lombok.Data;

@Data
public class AddRouteDto {

    private City fromCity;

    private City toCity;

    private String stopsInBetween;
}
