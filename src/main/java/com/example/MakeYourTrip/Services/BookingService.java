package com.example.MakeYourTrip.Services;

import com.example.MakeYourTrip.Models.*;
import com.example.MakeYourTrip.Repositories.BookingRepository;
import com.example.MakeYourTrip.Repositories.TransportRepository;
import com.example.MakeYourTrip.Repositories.UserRepository;
import com.example.MakeYourTrip.RequestDto.BookingRequest;
import com.example.MakeYourTrip.RequestDto.GetAvailableSeatDTO;
import com.example.MakeYourTrip.ResponceDtos.AvailableSeats;
import com.example.MakeYourTrip.Transformers.BookingTransformers;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
@Data
public class BookingService {


   @Autowired
    private BookingRepository bookingRepository;

   @Autowired
   private UserRepository userRepository;

   @Autowired
   private TransportRepository transportRepository;



   public List<AvailableSeats> getAvailableSeats(GetAvailableSeatDTO seatDTO){


       List<Booking> bookingList = bookingRepository.findBookings(seatDTO.getJourneyDate(),seatDTO.getTransportId());

       Set<String> bookedSeats = new TreeSet<>();

       for(Booking booking : bookingList){

           String str = booking.getSeatNos();
           String[] AllSeats = str.split(" ");

           for(String seatNo : AllSeats){

              bookedSeats.add(seatNo);
           }
       }

        Transport transport = transportRepository.findById(seatDTO.getTransportId()).get();

        List<Seat> seatList = transport.getSeatList();

        List<AvailableSeats> FinalavailableSeats = new ArrayList<>();

        for(Seat seat : seatList){

            if(bookedSeats.contains(seat.getSeatNo())){
                continue;
            }else{
                AvailableSeats availableSeats = AvailableSeats.builder().seatNo(seat.getSeatNo())
                                                               .seatPrice(seat.getPrice())
                                                               .seatType(seat.getSeatType())
                                                               .build();
                FinalavailableSeats.add(availableSeats);
            }
        }

        return FinalavailableSeats;
   }


   public ResponseEntity makeABooking(BookingRequest bookingRequest){

       User userobj = userRepository.findById(bookingRequest.getUserId()).get();

       Transport transportobj = transportRepository.findById(bookingRequest.getTransportId()).get();

       Booking booking = BookingTransformers.convertToBooking(bookingRequest);

       TicketEntity ticketEntity = createTicket(transportobj,bookingRequest);

       ///Setting up the Foreign keys
       booking.setTransport(transportobj);
       booking.setUser( userobj);
       booking.setTicketEntity(ticketEntity);


       ///now we will set the bidirectional mappings
       ///setting the booking object in transport
       ticketEntity.setBooking(booking);

       ///adding booking object in booking list in trasport
       transportobj.getBookings().add(booking);

       ///now we will add booking object in userobject
       userobj.getBookingList().add(booking);

       ///we will have to save it also ..but how..?

       bookingRepository.save(booking);

       return new ResponseEntity("booking has been done Successfully", HttpStatus.OK);

   }

   public TicketEntity createTicket(Transport transport , BookingRequest bookingRequest){

       Integer totalPricePaid = findtotalPricePaid(transport,bookingRequest.getSeatNo());

       String routeDetails = getRouteDetails(transport);

       TicketEntity ticketEntity = TicketEntity.builder()
                                  .allSeatNos(bookingRequest.getSeatNo())
                                  .journeyDate(transport.getJourneyDate())
                                  .startTime(transport.getStartTime())
                                  .routeDetails(routeDetails)
                                  .totalCostPaid(totalPricePaid)
                                  .build();
       return ticketEntity;
   }


   public Integer findtotalPricePaid(Transport transport,String seatNos){

       ///calculate price here
       List<Seat> seatList = transport.getSeatList();

       String[] AllseatNos = seatNos.split(",");

       Integer totalPrize =0;

       for(String seatNo : AllseatNos){

           for(Seat seat : seatList){

               if(seat.getSeatNo().equals(seatNo)){

                   totalPrize+=seat.getPrice();
               }
           }
       }

     return totalPrize;
   }

   public String getRouteDetails(Transport transport){

       Routes routes  = transport.getRoutes();

       String Result = routes.getFromCity()+" To "+routes.getToCity();

       return Result;
   }


}
