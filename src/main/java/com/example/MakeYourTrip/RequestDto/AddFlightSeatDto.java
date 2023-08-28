package com.example.MakeYourTrip.RequestDto;

import lombok.Data;

@Data
public class AddFlightSeatDto {

    private Integer noOfEconomySeats;

    private Integer noOfBuisnessSeats;

    private Integer priceOfBuisnessSeats;

    private Integer priceOfEconomySeats;

    private Integer transportId;
}
