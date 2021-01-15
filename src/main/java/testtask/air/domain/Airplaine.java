package testtask.air.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "airplane")
public class Airplaine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String airplaneName;
    private int serialNumber;
    private Long airCompanyId;
    private int numberOfFlight;
    private int flightDistance;
    private int fuelCapacity;
    private String type;
    private LocalDate createdAt;

    public Airplaine() {
    }

    public Airplaine(String airPlaneName, int serialNumber, Long airCompanyId, int numberOfFlight, int flightDistance, int fuelCapacity, String type, LocalDate createdAt) {
        this.airplaneName = airPlaneName;
        this.serialNumber = serialNumber;
        this.airCompanyId = airCompanyId;
        this.numberOfFlight = numberOfFlight;
        this.flightDistance = flightDistance;
        this.fuelCapacity = fuelCapacity;
        this.type = type;
        this.createdAt = createdAt;
    }

    public String getAirPlaneName() {
        return airplaneName;
    }

    public void setAirPlaneName(String airPlaneName) {
        this.airplaneName = airPlaneName;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Long getAirCompanyId() {
        return airCompanyId;
    }

    public void setAirCompanyId(Long airCompanyId) {
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
