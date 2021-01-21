package testtask.air.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import testtask.air.domain.AirCompany;

public interface AirCompanyRepo extends JpaRepository<AirCompany, Long> {
    AirCompany findAirCompanyByAirCompanyName(String name);
}
