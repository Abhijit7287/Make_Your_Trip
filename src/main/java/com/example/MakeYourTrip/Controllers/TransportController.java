package com.example.MakeYourTrip.Controllers;

import com.example.MakeYourTrip.RequestDto.AddTransport;
import com.example.MakeYourTrip.RequestDto.SearchFlightDto;
import com.example.MakeYourTrip.ResponceDtos.FlightResult;
import com.example.MakeYourTrip.Services.TransportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transport")
@Slf4j
public class TransportController {

    @Autowired
    private TransportService transportService;

    @PostMapping("/add")
    public ResponseEntity addTransport(@RequestBody AddTransport addTransport){

        try {

            String result = transportService.addTransport(addTransport);
            return new ResponseEntity(result, HttpStatus.OK);

        }catch(Exception e){
            log.error("Add transport has failed {}",e.getMessage());
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }



    @GetMapping("/searchFlight")
    public ResponseEntity searchFlight(SearchFlightDto searchFlightDto){


        List<FlightResult> result = transportService.searchFlights(searchFlightDto);

        return new ResponseEntity(result,HttpStatus.OK);

    }
}
