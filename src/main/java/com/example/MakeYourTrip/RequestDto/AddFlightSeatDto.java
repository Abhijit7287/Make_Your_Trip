package com.example.MakeYourTrip.RequestDto;


import lombok.Data;

@Data
public class AddFlightSeatDto {

    private int noOfEconomySeats;

    private int noOfBusinessSeats;

    private int priceOfBusinessSeats;

    private int priceOfEconomySeats;

    private int transportId;
}
