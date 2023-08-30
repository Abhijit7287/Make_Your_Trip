package com.example.MakeYourTrip.ResponceDtos;

import com.example.MakeYourTrip.Enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AvailableSeats {

   private String seatNo;

   private SeatType seatType;

   private Integer seatPrice;
}
