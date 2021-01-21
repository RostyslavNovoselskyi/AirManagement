package testtask.air.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import testtask.air.domain.Airplane;

public interface AirplaneRepo extends JpaRepository<Airplane, Long> {
    Airplane findByid(Long id);
}
