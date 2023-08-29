package com.example.MakeYourTrip.Transformers;

import com.example.MakeYourTrip.Models.Routes;
import com.example.MakeYourTrip.RequestDto.AddRouteDto;
import lombok.Data;

@Data
public class RouteTransformer {

    public static Routes convertDtotoEntity(AddRouteDto addRouteDto){

        Routes object = Routes.builder().fromCity(addRouteDto.getFromCity())
                        .toCity(addRouteDto.getToCity())
                        .listofStopsInbetween(addRouteDto.getStopsInBetween())
                        .modeofTransport(addRouteDto.getModeofTransport()).build();

         return object;
    }
}
