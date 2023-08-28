package com.example.MakeYourTrip.Transformers;

import com.example.MakeYourTrip.Models.Booking;
import com.example.MakeYourTrip.RequestDto.BookingRequest;

public class BookingTransformers {


    public static Booking convertToBooking(BookingRequest bookingRequest){

        Booking bookingObj = Booking.builder().transportId(bookingRequest.getTransportId())
                                           .JourneyDate(bookingRequest.getJournyDate())
                                           .seatNos(bookingRequest.getSeatNo())
                                           .build();
        return bookingObj;
    }
}
