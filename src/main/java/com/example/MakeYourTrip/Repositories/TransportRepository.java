package com.example.MakeYourTrip.Repositories;

import com.example.MakeYourTrip.Models.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportRepository extends JpaRepository<Transport,Integer>{

}
