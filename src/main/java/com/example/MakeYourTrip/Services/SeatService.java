package com.example.MakeYourTrip.Services;

import com.example.MakeYourTrip.Enums.SeatType;
import com.example.MakeYourTrip.Models.Seat;
import com.example.MakeYourTrip.Models.Transport;
import com.example.MakeYourTrip.Repositories.SeatRepository;
import com.example.MakeYourTrip.Repositories.TransportRepository;
import com.example.MakeYourTrip.RequestDto.AddFlightSeatDto;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Data
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private TransportRepository transportRepository;


     public ResponseEntity addFlightSeats(AddFlightSeatDto seatDto){

         Transport transportObj = transportRepository.findById(seatDto.getTransportId()).get();

         for(int i=1;i<seatDto.getNoOfEconomySeats();i++){

             Seat seat = Seat.builder().seatNo("E"+i)
                         .seatType(SeatType.ECONOMY)
                         .price(seatDto.getPriceOfEconomySeats())
                         .transport(transportObj)
                         .build();

             ///setting the seatList of transportobj
             transportObj.getSeatList().add(seat);
         }


         for(int i=1;i<seatDto.getNoOfBuisnessSeats();i++){

             Seat seat = Seat.builder().seatNo("B"+i)
                             .seatType(SeatType.BUISSNESS)
                             .price(seatDto.getPriceOfBuisnessSeats())
                             .transport(transportObj)
                             .build();

            ///setting the seatList of transportobj
             transportObj.getSeatList().add(seat);
         }
         ///because of Bidirectional mapping Seat object will automatically get saved
         transportRepository.save(transportObj);

         return new ResponseEntity("Seats has been added Successfully", HttpStatus.OK);
     }
}
