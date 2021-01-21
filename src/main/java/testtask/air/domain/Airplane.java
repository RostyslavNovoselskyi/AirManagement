package testtask.air.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "airplane")
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String airplaneName;
    private int serialNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn()
    private AirCompany airCompanyId;

    private int numberOfFlight;
    private int flightDistance;
    private int fuelCapacity;
    private String type;
    private LocalDate createdAt;

    @OneToMany
    private Set<Flight> flights;

    public Airplane() {
    }

    public Airplane(String airplaneName, int serialNumber, AirCompany airCompanyId,
                    int numberOfFlight, int flightDistance, int fuelCapacity, String type,
                    LocalDate createdAt
    ) {
        this.airplaneName = airplaneName;
        this.serialNumber = serialNumber;
        this.airCompanyId = airCompanyId;
        this.numberOfFlight = numberOfFlight;
        this.flightDistance = flightDistance;
        this.fuelCapacity = fuelCapacity;
        this.type = type;
        this.createdAt = createdAt;
    }

    public Set<Flight> getFlights() {
        return flights;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAirplaneName() {
        return airplaneName;
    }

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public AirCompany getAirCompanyId() {
        return airCompanyId;
    }

    public void setAirCompanyId(AirCompany airCompanyId) {
        this.airCompanyId = airCompanyId;
    }

    public int getNumberOfFlight() {
        return numberOfFlight;
    }

    public void setNumberOfFlight(int numberOfFlight) {
        this.numberOfFlight = numberOfFlight;
    }

    public int getFlightDistance() {
        return flightDistance;
    }

    public void setFlightDistance(int flightDistance) {
        this.flightDistance = flightDistance;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
