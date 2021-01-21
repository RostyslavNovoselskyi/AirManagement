package testtask.air.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import testtask.air.domain.AirCompany;
import testtask.air.exceptions.ResourceNotFoundException;
import testtask.air.repos.AirCompanyRepo;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("air")
public class AirController {
    @Autowired
    private AirCompanyRepo airCompanyRepo;

    @GetMapping
    public List<AirCompany> listCompanies(){
        return airCompanyRepo.findAll();
    }

    @PostMapping
    public AirCompany create( @RequestBody AirCompany airCompany){
        return airCompanyRepo.save(airCompany);
    }

    @PutMapping("{id}")
    public AirCompany updateCompany(@PathVariable Long id, @Valid @RequestBody AirCompany companyRequest){
        return airCompanyRepo.findById(id).map(company -> {
            company.setAirCompanyName(companyRequest.getAirCompanyName());
            company.setCompanyType(companyRequest.getCompanyType());
            company.setFoundedAt(companyRequest.getFoundedAt());
            return airCompanyRepo.save(company);
        }).orElseThrow(() -> new ResourceNotFoundException("CompanyId " + id + " not found"));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable Long id){
        return airCompanyRepo.findById(id).map(company -> {
            airCompanyRepo.delete(company);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("CompanyId " + id + " not found"));
    }
}
