package com.example.MakeYourTrip.Controllers;

import com.example.MakeYourTrip.RequestDto.AddFlightSeatDto;
import com.example.MakeYourTrip.Services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Seat")
public class SeatController {


    @Autowired
    private SeatService seatService;

   @PostMapping("/addSeats")
    public ResponseEntity addSeats(AddFlightSeatDto addFlightSeatDto){

     return seatService.addFlightSeats(addFlightSeatDto);
   }
}
