package com.example.MakeYourTrip.Models;

import com.example.MakeYourTrip.Enums.SeatType;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Builder
public class Seat {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatId;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private Integer price;

    @ManyToOne
    @JoinColumn
    private Transport transport;
}
