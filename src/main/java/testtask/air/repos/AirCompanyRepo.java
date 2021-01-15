package testtask.air.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import testtask.air.domain.AirCompany;

import java.util.List;

public interface AirCompanyRepo extends JpaRepository<AirCompany, Long> {
//    AirCompany findByAirCompanyId(Long id);

//    @Override
//    List<AirCompany> findAll();

}
