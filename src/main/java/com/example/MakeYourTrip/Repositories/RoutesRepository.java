package com.example.MakeYourTrip.Repositories;

import com.example.MakeYourTrip.Models.Routes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutesRepository extends JpaRepository<Routes,Integer>{

}
