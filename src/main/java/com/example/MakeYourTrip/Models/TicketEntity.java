package com.example.MakeYourTrip.Models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "ticket")
@Data
@Builder
public class TicketEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;

    private String routeDetails;

    private LocalDate JourneyDate;

    private LocalTime startTime;

    private Integer totalCostPaid;

    private String allSeatNos;

    @OneToOne
    @JoinColumn
    private Booking booking;

}
