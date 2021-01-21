package testtask.air.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import testtask.air.domain.Flight;
import testtask.air.enums.FlightStatus;
import testtask.air.exceptions.ResourceNotFoundException;
import testtask.air.repos.AirCompanyRepo;
import testtask.air.repos.FlightRepo;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("flight")
public class FlightController {
    @Autowired
    private FlightRepo flightRepo;

    @GetMapping("flight")
    public List<Flight> listOfFlights(){
        return flightRepo.findAll();
    }

    @GetMapping("flight/status")
    public Iterable<Flight> listWithDifference(){
        LocalDateTime d1 = LocalDateTime.now();
        d1 = d1.minusHours(24);
        Iterable<Flight> flightsByStartAtBefore = flightRepo.findFlightsByStartAtBefore(d1);
        Iterable<Flight> flightsByStatus = flightRepo.findFlightsByFlightStatus(FlightStatus.ACTIVE);

        if (flightsByStatus.getClass().isAssignableFrom(flightsByStartAtBefore.getClass())){
            return flightsByStartAtBefore.getClass().cast(flightsByStatus);
        }
        return null;
    }

    @PostMapping("flight")
    public Flight createFlight(@RequestBody Flight flight){
        flight.setFlightStatus(FlightStatus.PENDING);
        LocalDate now = LocalDate.now();
        flight.setFlightCreatedDate(now);
        flight.setDelayStartAt(null);
        flight.setStartAt(null);
        flight.setEndAt(null);
        return flightRepo.save(flight);
    }

    @PutMapping("flight/{id}")
    public Flight updateFlightStatus(@PathVariable Long id, @Valid @RequestBody Flight flightRequest){
        Optional<Flight> byId = flightRepo.findById(id);
        LocalDateTime now = LocalDateTime.now();

        return flightRepo.findById(id).map(flight -> {
            if (flightRequest.getFlightStatus().equals(FlightStatus.DELAYED)){
                flight.setFlightStatus(FlightStatus.DELAYED);
                flight.setDelayStartAt(now);
            } else if (flightRequest.getFlightStatus().equals(FlightStatus.ACTIVE)){
                flight.setFlightStatus(FlightStatus.ACTIVE);
                flight.setDelayStartAt(byId.get().getDelayStartAt());
                flight.setStartAt(now);
//                flight.setStartAt(byId.get().getStartAt());//////////
            } else if (flightRequest.getFlightStatus().equals(FlightStatus.COMPLETED)){
                flight.setFlightStatus(FlightStatus.COMPLETED);
                flight.setDelayStartAt(byId.get().getDelayStartAt());
                flight.setStartAt(byId.get().getStartAt());
                flight.setEndAt(now);
            }
            flight.setAirCompanyId(byId.get().getAirCompanyId());
            flight.setAirplaneId(byId.get().getAirplaneId());
            flight.setDepartureCountry(byId.get().getDepartureCountry());
            flight.setDestinationCountry(byId.get().getDestinationCountry());
            flight.setDistance(byId.get().getDistance());
            flight.setEstimatedFlightTime(byId.get().getEstimatedFlightTime());
            flight.setFlightCreatedDate(byId.get().getFlightCreatedDate());
            return flightRepo.save(flight);
        }).orElseThrow(() -> new ResourceNotFoundException("flightId " + id + " not found"));
    }
}
