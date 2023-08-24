package com.example.MakeYourTrip.Services;

import com.example.MakeYourTrip.Exceptions.RouteNotfoundException;
import com.example.MakeYourTrip.Models.Routes;
import com.example.MakeYourTrip.Models.Transport;
import com.example.MakeYourTrip.Repositories.RoutesRepository;
import com.example.MakeYourTrip.Repositories.TransportRepository;
import com.example.MakeYourTrip.RequestDto.AddTransport;
import com.example.MakeYourTrip.Transformers.TransportTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        ///here both Routes and Transport are in Birecional mapping hence
        ///saving only parent is enough child  will automatically get saved
        routesRepository.save(routes);


        return "Transport has been added Successfully";
    }
}
