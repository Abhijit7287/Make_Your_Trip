package com.example.MakeYourTrip.Models;


import com.example.MakeYourTrip.Enums.City;
import com.example.MakeYourTrip.Enums.ModeofTransport;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "routes")
@Data
public class Routes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer routeId;

    private City fromCity;

    private City toCity;

    private String ListofStopsInbetween;

    private ModeofTransport modeofTransport;
}
