package com.example.MakeYourTrip.Transformers;

import com.example.MakeYourTrip.Models.Transport;
import com.example.MakeYourTrip.RequestDto.AddTransport;

public class TransportTransformers {

    public static Transport convertclasstoDto(AddTransport addTransport){

     Transport object = Transport.builder().JourneyTime(addTransport.getJourneyTime())
                        .Journydate(addTransport.getJournydate())
                        .modeofTransport(addTransport.getModeofTransport())
                        .startTime(addTransport.getStartTime()).build();

     return object;

    }
}
