package testtask.air.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import testtask.air.domain.Airplaine;

public interface AirplaneRepo extends JpaRepository<Airplaine, Long> {
    Airplaine findByAirplaneName(String airplaneName);
}
