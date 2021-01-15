package testtask.air.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import testtask.air.domain.AirCompany;
import testtask.air.domain.CompanyType;
import testtask.air.repos.AirCompanyRepo;

@RestController
@RequestMapping("air")
public class AirController {
    @Autowired
    private AirCompanyRepo airCompanyRepo;

    @GetMapping
    public Iterable<AirCompany> list(){
        return airCompanyRepo.findAll();
    }

//    @GetMapping
//    public List<AirCompany> getAllCompanies(){
//        return airCompanyRepo.findAll();
//    }

//    @GetMapping("{id}")
//    public Optional<AirCompany> getOne(@PathVariable Long id){
//        return getAir(id);
//    }

//    private Optional<AirCompany> getAir(Long id) {
//        return airCompanyRepo.findById(id);
//    }

    @PostMapping
    public Iterable<AirCompany> create(@RequestBody AirCompany airCompany){

        String s = airCompany.getCompanyType();

        if (s.equals("1")){
            airCompany.setCompanyType(CompanyType.PASSENGER_TRANSPORTATION.toString());
        }else if (s.equals("2")){
            airCompany.setCompanyType(CompanyType.GOODS_TRANSPORTATION.toString());
        }else if (s.equals("3")){
            airCompany.setCompanyType(CompanyType.ANIMAL_TRANSPORTATION.toString());
        }

        airCompanyRepo.save(airCompany);

        Iterable<AirCompany> airCompanies = airCompanyRepo.findAll();

        return airCompanies;
    }

    



//    @PostMapping
//    public AirCompany createCompany(@Valid @RequestBody AirCompany company){
//        return airCompanyRepo.save(company);
//    }

//    @GetMapping("/{id}")
//    public AirCompany getCompanyById(@PathVariable(value = "id") Long id) throws NotFoundException {
//        return airCompanyRepo.findById(id)
//                .orElseThrow(() -> new NotFoundException());
//    }


//    @PutMapping("/{id}")
//    public AirCompany updateCompany(@PathVariable(value = "id") Long id,
//                           @Valid @RequestBody AirCompany bookDetails) throws NotFoundException {
//
//        AirCompany company = airCompanyRepo.findById(id)
//                .orElseThrow(() -> new NotFoundException());
//
//        company.setName(bookDetails.getName());
//        company.setCompanyType(bookDetails.getCompanyType());
//        company.setFoundedAt(bookDetails.getFoundedAt());
//
//        AirCompany updatedCompany = airCompanyRepo.save(company);
//
//        return updatedCompany;
//    }






//    @PutMapping("/{Id}")
//    public String updateAirCompany(@PathVariable Long id, @RequestBody AirCompany requestCompanyDetails){
//        return "updated";
//    }




//    @PutMapping("/users/{id}")
//    public ResponseEntity<AirCompany> updateUser(
//            @PathVariable(value = "id") Long userId,
//            @Valid @RequestBody AirCompany userDetails) throws ResourceNotFoundException {
//        AirCompany user = userRepository.findById(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ userId));
//
//        user.setEmailId(userDetails.getEmailId());
//        user.setLastName(userDetails.getLastName());
//        user.setFirstName(userDetails.getFirstName());
//        user.setUpdatedAt(new Date());
//        final User updatedUser = userRepository.save(user);
//        return ResponseEntity.ok(updatedUser);
//    }




//    @PutMapping("{id}")
//    public Map<AirCompany, String> update(@PathVariable Long id, @RequestBody AirCompany airCompany){
//        Map<AirCompany, String> airFromDb = getAir(id);
//
//        airFromDb.putAll(airCompany);
//        airFromDb.put(id, id);
//
//        return airFromDb;
//    }
//
//    @DeleteMapping("{id}")
//    public void delete(@PathVariable Long id){
//        Optional<AirCompany> air = getAir(id);
//        airCompanyRepo.findById(id).
//
//        AirCompany.;
//    }

}
