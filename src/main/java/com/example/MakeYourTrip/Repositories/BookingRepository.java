package com.example.MakeYourTrip.Repositories;

import com.example.MakeYourTrip.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer>{

    @Query(value = "select * from bookings where JourneyDate=journeyDate and transportId=transportIdInput",nativeQuery = true)
    List<Booking> findBookings(LocalDate journeyDate , Integer trasportIdInput);
}
