package com.example.MakeYourTrip.RequestDto;

import com.example.MakeYourTrip.Enums.City;
import com.example.MakeYourTrip.Enums.ModeofTransport;
import lombok.Data;

@Data
public class AddRouteDto {

    private City fromCity;

    private City toCity;

    private String stopsInBetween;

    private ModeofTransport modeofTransport;
}
