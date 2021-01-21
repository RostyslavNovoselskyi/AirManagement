package testtask.air.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import testtask.air.domain.Flight;
import testtask.air.enums.FlightStatus;

import java.time.LocalDateTime;

public interface FlightRepo extends JpaRepository<Flight, Long> {
    Iterable<Flight> findFlightsByFlightStatus(FlightStatus flightStatus);

    Iterable<Flight> findFlightsByStartAtBefore(LocalDateTime startAt);
}
