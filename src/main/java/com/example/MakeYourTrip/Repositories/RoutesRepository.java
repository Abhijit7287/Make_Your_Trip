package com.example.MakeYourTrip.Repositories;

        import com.example.MakeYourTrip.Enums.City;
        import com.example.MakeYourTrip.Enums.ModeOfTransport;
        import com.example.MakeYourTrip.Models.Routes;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.stereotype.Repository;

        import java.util.List;

@Repository
public interface RoutesRepository extends JpaRepository<Routes,Integer>{
    @Query(value = "select * from routes where from_city = from_city AND to_city = to_city AND mode_of_transport = mode_of_transport;" , nativeQuery = true)
    List<Routes> find(City from_city, City to_city, ModeOfTransport mode_of_transport);
}
