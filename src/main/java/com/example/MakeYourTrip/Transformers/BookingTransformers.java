package com.example.MakeYourTrip.Transformers;

import com.example.MakeYourTrip.Models.Booking;
import com.example.MakeYourTrip.RequestDto.BookingRequest;
import lombok.Data;

@Data
public class BookingTransformers {

    public static Booking convertToBooking(BookingRequest bookingRequest){

        Booking bookingObj = Booking.builder().transportId(bookingRequest.getTransportId())
                                           .journeyDate(bookingRequest.getJourneyDate())
                                           .seatNos(bookingRequest.getSeatNo())
                                           .build();
        return bookingObj;
    }
}
