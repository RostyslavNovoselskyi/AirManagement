package testtask.air;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AirApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirApplication.class, args);
	}

}
