package com.example.MakeYourTrip.Services;

import com.example.MakeYourTrip.Enums.ModeOfTransport;
import com.example.MakeYourTrip.Exceptions.RouteNotfoundException;
import com.example.MakeYourTrip.Models.Routes;
import com.example.MakeYourTrip.Models.Transport;
import com.example.MakeYourTrip.Repositories.RoutesRepository;
import com.example.MakeYourTrip.Repositories.TransportRepository;
import com.example.MakeYourTrip.RequestDto.AddTransport;
import com.example.MakeYourTrip.RequestDto.SearchFlightDto;
import com.example.MakeYourTrip.ResponceDtos.FlightResult;
import com.example.MakeYourTrip.Transformers.TransportTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransportService {

    @Autowired
    private TransportRepository transportRepository;

    @Autowired
    private RoutesRepository routesRepository;

    public String addTransport(AddTransport addTransport) throws Exception {

        Transport transportObj = TransportTransformers.convertclasstoDto(addTransport);

        Optional<Routes> optionalRoutes = routesRepository.findById(addTransport.getRouteId());

        if(!optionalRoutes.isPresent()){
            throw new RouteNotfoundException("Route Id is incorrect");
        }

        Routes routes = optionalRoutes.get();

        ///we are setting FK column here
        transportObj.setRoutes(routes);

        //Bidirectional mapping also needs to be taken care of
        routes.getTransportList().add(transportObj);

        ///here both Routes and Transport are in Birecional mapping hence
        ///saving only parent is enough child  will automatically get saved
        routesRepository.save(routes);


        return "Transport has been added Successfully";
    }


    public List<FlightResult> searchFlights(SearchFlightDto searchFlightDto){

       ///first get the list of routes according fromCity and toCity and ModeOftransport
        List<Routes> routesList = routesRepository.find(searchFlightDto.getFromCity(),searchFlightDto.getToCity(), ModeOfTransport.FLIGHT);
        ///create list of flightResult for returning
        List<FlightResult> flightResults = new ArrayList<>();

        ///traverse through each route
        for(Routes routes : routesList){

            List<Transport> transportList = routes.getTransportList();
          ///traverse through each transport and if journydate is equal build the flightResult object
            for(Transport transport : transportList){

                if(transport.getJourneyDate().equals(searchFlightDto.getJourneyDate())){
            ///build the Flightresult object from traansport object(using attributes of transport object)
                    FlightResult result = TransportTransformers.convertToFlightResult(transport);
                    ///traansport object does not contains setListOfStopInBetween so
                    ///we are getting it from route object
                    result.setListOfStopInBetween(routes.getListOfStopsInBetween());
                    flightResults.add(result);
                }
            }
        }

        return flightResults;
    }
}
