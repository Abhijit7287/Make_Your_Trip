package com.example.MakeYourTrip.Transformers;

import com.example.MakeYourTrip.Models.Transport;
import com.example.MakeYourTrip.RequestDto.AddTransport;
import com.example.MakeYourTrip.ResponceDtos.FlightResult;
import lombok.Data;

@Data
public class TransportTransformers {

    public static Transport convertclasstoDto(AddTransport addTransport){

     Transport object = Transport.builder().journeyTime(addTransport.getJourneyTime())
                        .journeyDate(addTransport.getJourneyDate())
                        .modeOfTransport(addTransport.getModeOfTransport())
                        .startTime(addTransport.getStartTime())
                        .companyName(addTransport.getCompanyName())
                        .build();

     return object;

    }

    public static FlightResult convertToFlightResult(Transport transport){

        FlightResult object = FlightResult.builder().journeyDate(transport.getJourneyDate())
                              .companyName(transport.getCompanyName())
                              .startTime(transport.getStartTime())
                              .journeyTime(transport.getJourneyTime()).build();

        return object;
    }
}
