package com.example.MakeYourTrip.ResponceDtos;

import com.example.MakeYourTrip.Enums.SeatType;
import lombok.Builder;
import lombok.Data;

import javax.jnlp.IntegrationService;

@Data
@Builder
public class AvailableSeats {

   private String seatNo;

   private SeatType seatType;

   private Integer seatPrice;
}
