package testtask.air.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import testtask.air.domain.Airplane;
import testtask.air.exceptions.ResourceNotFoundException;
import testtask.air.repos.AirplaneRepo;

import javax.validation.Valid;

@RestController
//@RequestMapping("airplane")
public class AirplaneController {
    @Autowired
    private AirplaneRepo airplaneRepo;

    @GetMapping("airplane")
    public Iterable<Airplane> listAirplanes(){
        return airplaneRepo.findAll();
    }

    @PostMapping("airplane")
    public Airplane createAirplane(@Valid @RequestBody(required = false) Airplane airplane){

//        Iterable<Airplane> airplaines = airplaneRepo.findAll();

        return airplaneRepo.save(airplane);
    }

    @PutMapping("airplane/{id}")
    public Airplane moveAirplane(@PathVariable Long id, @Valid @RequestBody Airplane airplaneRequest){
        Airplane airplaneById = airplaneRepo.findByid(id);

        return airplaneRepo.findById(id).map(airplane -> {
            airplane.setAirplaneName(airplaneById.getAirplaneName());
            airplane.setSerialNumber(airplaneById.getSerialNumber());
            airplane.setAirCompanyId(airplaneRequest.getAirCompanyId());
            airplane.setNumberOfFlight(airplaneById.getNumberOfFlight());
            airplane.setFlightDistance(airplaneById.getFlightDistance());
            airplane.setFuelCapacity(airplaneById.getFuelCapacity());
            airplane.setType(airplaneById.getType());
            airplane.setCreatedAt(airplaneById.getCreatedAt());
            return airplaneRepo.save(airplane);
        }).orElseThrow(() -> new ResourceNotFoundException("AirplaneId " + id + " not found"));
    }

}
