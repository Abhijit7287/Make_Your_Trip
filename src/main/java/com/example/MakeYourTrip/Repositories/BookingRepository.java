package com.example.MakeYourTrip.Repositories;

import com.example.MakeYourTrip.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer>{

    @Query(value ="select * from bookings where journey_date=journey_date and transport_Id=transport_Id;",nativeQuery = true)
    List<Booking> findBookings(LocalDate journey_date , Integer transport_Id);
}
