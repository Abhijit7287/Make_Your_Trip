package com.example.MakeYourTrip.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "ticket")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;

    private String routeDetails;

    private LocalDate journeyDate;

    private LocalTime startTime;

    private Integer totalCostPaid;

    private String allSeatNos;

    @OneToOne
    @JoinColumn
    private Booking booking;

}
