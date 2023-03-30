package co.develhope.customqueries2.repositories;

import co.develhope.customqueries2.entities.Flight;
import co.develhope.customqueries2.entities.FlightStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    Page<Flight> findAll(Pageable pageable);

    Page<Flight> findAllByStatus(FlightStatus status, Pageable pageable);

    @Query(value = "SELECT * FROM flight as f where f.status = ? OR f.status= ?",nativeQuery = true)
    List<Flight> findByStatusOrStatus(String p1, String p2);
}