package com.example.MakeYourTrip.Models;


import com.example.MakeYourTrip.Enums.City;
import com.example.MakeYourTrip.Enums.ModeofTransport;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "routes")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Routes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer routeId;

    @Enumerated(value = EnumType.STRING)
    private City fromCity;

    @Enumerated(value = EnumType.STRING)
    private City toCity;

    private String listofStopsInbetween;

    @Enumerated(value = EnumType.STRING)
    private ModeofTransport modeofTransport;

    @OneToMany(mappedBy = "routes",cascade = CascadeType.ALL)
    private List<Transport> transportList  = new ArrayList<>();

}
