package com.example.MakeYourTrip.Models;

import com.example.MakeYourTrip.Enums.SeatType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Seat {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatId;

    private String seatNo;

    private SeatType seatType;

    private Integer price;

    @ManyToOne
    @JoinColumn
    private Transport transport;
}
