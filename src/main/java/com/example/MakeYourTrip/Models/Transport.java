package com.example.MakeYourTrip.Models;


import com.example.MakeYourTrip.Enums.ModeofTransport;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="transport")
@Data
public class Transport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transportId;

    private ModeofTransport modeofTransport;

    private LocalDate Journydate;

    private LocalTime startTime;

    private double JourneyTime;

    @ManyToOne
    @JoinColumn
    private Routes routes;

    @OneToMany(mappedBy = "transport",cascade = CascadeType.ALL)
    private Seat seat;

    @OneToMany(mappedBy = "transport",cascade = CascadeType.ALL)
    List<Booking>bookings = new ArrayList<>();

}
