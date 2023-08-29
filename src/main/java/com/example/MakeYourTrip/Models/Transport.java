package com.example.MakeYourTrip.Models;


import com.example.MakeYourTrip.Enums.ModeofTransport;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="transport")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transportId;

    @Enumerated(value = EnumType.STRING)
    private ModeofTransport modeofTransport;

    private LocalDate JourneyDate;

    private LocalTime startTime;

    private double JourneyTime;

    private String companyName;

    @ManyToOne
    @JoinColumn
    private Routes routes;

    @OneToMany(mappedBy = "transport",cascade = CascadeType.ALL)
    private List<Seat> seatList = new ArrayList<>();

    @OneToMany(mappedBy = "transport",cascade = CascadeType.ALL)
    private List<Booking> bookings = new ArrayList<>();

}
