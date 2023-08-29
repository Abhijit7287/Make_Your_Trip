package com.example.MakeYourTrip.Models;

import com.sun.javafx.beans.IDProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "bookings")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
///this will keep record of already booked Seats on a perticullar date
///of a perticullar transportId
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    private String seatNos; ///this will ne comma seprated values like 1A,2A,3A

    private LocalDate JourneyDate;

    private Integer transportId;


    @ManyToOne
    @JoinColumn
    private Transport transport;

    @OneToOne(mappedBy = "booking",cascade = CascadeType.ALL)
    private TicketEntity ticketEntity;

    @ManyToOne
    @JoinColumn
    private User user;
}
