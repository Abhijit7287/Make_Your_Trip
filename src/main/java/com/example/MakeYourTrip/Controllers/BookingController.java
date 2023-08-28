package com.example.MakeYourTrip.Controllers;

import com.example.MakeYourTrip.Models.Booking;
import com.example.MakeYourTrip.RequestDto.BookingRequest;
import com.example.MakeYourTrip.RequestDto.GetAvailableSeatDTO;
import com.example.MakeYourTrip.ResponceDtos.AvailableSeats;
import com.example.MakeYourTrip.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {


   @Autowired
   private BookingService bookingService;


   @PostMapping("/bookFlight")
    public ResponseEntity bookFlight(@RequestBody BookingRequest bookingRequest){

       return bookingService.makeABooking(bookingRequest);
   }


   @GetMapping("/getAvailableSeats")
   public ResponseEntity getAvailableSeats(@RequestBody GetAvailableSeatDTO getAvailableSeatDTO){

      List<AvailableSeats> result = bookingService.getAvailableSeats(getAvailableSeatDTO);

      return new ResponseEntity(result , HttpStatus.OK);
   }

}
