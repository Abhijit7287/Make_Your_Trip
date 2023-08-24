package com.example.MakeYourTrip.Models;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String name;

    private String emailId;

    private Integer age;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Booking>bookingList = new ArrayList<>();

}
