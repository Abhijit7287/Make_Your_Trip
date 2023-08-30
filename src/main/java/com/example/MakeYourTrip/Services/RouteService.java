package com.example.MakeYourTrip.Services;


import com.example.MakeYourTrip.Models.Routes;
import com.example.MakeYourTrip.Repositories.RoutesRepository;
import com.example.MakeYourTrip.RequestDto.AddRouteDto;
import com.example.MakeYourTrip.Transformers.RouteTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    @Autowired
    private RoutesRepository routesRepository;

    public String addRoutes(AddRouteDto addRouteDto){

        Routes object = RouteTransformer.convertDtotoEntity(addRouteDto);

        routesRepository.save(object);

        return "Routes has added Successfully";
    }
}

