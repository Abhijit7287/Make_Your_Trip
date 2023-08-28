package com.example.MakeYourTrip.Transformers;

import com.example.MakeYourTrip.Models.Transport;
import com.example.MakeYourTrip.RequestDto.AddTransport;
import com.example.MakeYourTrip.RequestDto.SearchFlightDto;
import com.example.MakeYourTrip.ResponceDtos.FlightResult;

public class TransportTransformers {

    public static Transport convertclasstoDto(AddTransport addTransport){

     Transport object = Transport.builder().JourneyTime(addTransport.getJourneyTime())
                        .Journydate(addTransport.getJournydate())
                        .modeofTransport(addTransport.getModeofTransport())
                        .startTime(addTransport.getStartTime())
                        .modeofTransport(addTransport.getModeofTransport())
                        .companyName(addTransport.getCompanyName())
                        .build();

     return object;

    }

    public static FlightResult convertToFlightResult(Transport transport){

        FlightResult object = FlightResult.builder().journeyDate(transport.getJournydate())
                              .companyName(transport.getCompanyName())
                              .startTime(transport.getStartTime())
                              .journeyTime(transport.getJourneyTime()).build();

        return object;
    }
}
