package testtask.air.domain;

import testtask.air.enums.CompanyType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class AirCompany {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String airCompanyName;

    @Enumerated(EnumType.STRING)
    private CompanyType companyType;

    private LocalDate foundedAt;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Airplane> airplanes;

//    mappedBy = "airCompanyId",
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Flight> flights;

    public AirCompany() {
    }

    public AirCompany(String airCompanyName, CompanyType companyType, LocalDate foundedAt) {
        this.airCompanyName = airCompanyName;
        this.companyType = companyType;
        this.foundedAt = foundedAt;
    }

    public Set<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Set<Flight> flights){
        this.flights = flights;
    }

    public Set<Airplane> getAirplanes() {
        return airplanes;
    }

    public void setAirplanes(Set<Airplane> airplanes) {
        this.airplanes = airplanes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAirCompanyName () {
        return airCompanyName;
    }

    public void setAirCompanyName(String name) {
        this.airCompanyName = name;
    }

    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }

    public LocalDate getFoundedAt() {
        return foundedAt;
    }

    public void setFoundedAt(LocalDate foundedAt) {
        this.foundedAt = foundedAt;
    }
}
