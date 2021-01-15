package testtask.air.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import testtask.air.domain.Airplaine;
import testtask.air.repos.AirplaneRepo;

@RestController
@RequestMapping("airplane")
public class AirplaneController {
    @Autowired
    private AirplaneRepo airplaneRepo;

    @GetMapping
    public String list(){

        return "";
    }

    @PostMapping
    public String createAirplane(@RequestBody Airplaine airplaine){


        return "";
    }

}
