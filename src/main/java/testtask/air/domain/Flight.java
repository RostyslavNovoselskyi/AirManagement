package testtask.air.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import testtask.air.enums.FlightStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private FlightStatus flightStatus;

//    , optional = false
    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "airCompanyId", nullable = false)
    private AirCompany airCompanyId;

    @ManyToOne(fetch = FetchType.EAGER)
    private Airplane airplaneId;

//    public String getAirCompanyName(){
//        return aircompanyId.getAirCompanyName() != null ? aircompanyId.getAirCompanyName() : "<none>";
//    }

    private String departureCountry;
    private String destinationCountry;
    private int distance;
    private int estimatedFlightTime;
    private LocalDateTime delayStartAt;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private LocalDate flightCreatedDate;

    public Flight() {
    }

    public Flight(FlightStatus flightStatus, AirCompany airCompanyId, Airplane airplaneId,
                  String departureCountry, String destinationCountry, int distance,
                  int estimatedFlightTime, LocalDateTime delayStartAt, LocalDateTime startAt,
                  LocalDateTime endAt, LocalDate flightCreatedDate
    ) {
        this.flightStatus = flightStatus;
        this.airCompanyId = airCompanyId;
        this.airplaneId = airplaneId;
        this.departureCountry = departureCountry;
        this.destinationCountry = destinationCountry;
        this.distance = distance;
        this.estimatedFlightTime = estimatedFlightTime;
        this.delayStartAt = delayStartAt;
        this.startAt = startAt;
        this.endAt = endAt;
        this.flightCreatedDate = flightCreatedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    public AirCompany getAirCompanyId() {
        return airCompanyId;
    }

    public void setAirCompanyId(AirCompany airCompanyId) {
        this.airCompanyId = airCompanyId;
    }

    public Airplane getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(Airplane airplaneId) {
        this.airplaneId = airplaneId;
    }

    public String getDepartureCountry() {
        return departureCountry;
    }

    public void setDepartureCountry(String departureCountry) {
        this.departureCountry = departureCountry;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getEstimatedFlightTime() {
        return estimatedFlightTime;
    }

    public void setEstimatedFlightTime(int estimatedFlightTime) {
        this.estimatedFlightTime = estimatedFlightTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getDelayStartAt() {
        return delayStartAt;
    }

    public void setDelayStartAt(LocalDateTime delayStartAt) {
        this.delayStartAt = delayStartAt;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getStartAt() {
        return startAt;
    }

    public void setStartAt(LocalDateTime startAt) {
        this.startAt = startAt;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getEndAt() {
        return endAt;
    }

    public void setEndAt(LocalDateTime endAt) {
        this.endAt = endAt;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public LocalDate getFlightCreatedDate() {
        return flightCreatedDate;
    }

    public void setFlightCreatedDate(LocalDate flightCreatedDate) {
        this.flightCreatedDate = flightCreatedDate;
    }
}
