package com.example.MakeYourTrip.Repositories;

import com.example.MakeYourTrip.Enums.City;
import com.example.MakeYourTrip.Enums.ModeofTransport;
import com.example.MakeYourTrip.Models.Routes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoutesRepository extends JpaRepository<Routes,Integer>{

    List<Routes> findRoutesbyFromCityAndToCityandModeOfTransport(City fromCity, City toCity, ModeofTransport modeofTransport);
}
