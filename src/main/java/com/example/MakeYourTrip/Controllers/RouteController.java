package com.example.MakeYourTrip.Controllers;

import com.example.MakeYourTrip.RequestDto.AddRouteDto;
import com.example.MakeYourTrip.Services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteService routeService;


    @PostMapping("/add")
    public String addRoute(@RequestBody AddRouteDto addRouteDto){

       routeService.addRoutes(addRouteDto);
        return "Routes has been added Successfully";
    }


}
