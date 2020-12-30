package albacorn.albacorn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@EnableJpaAuditing
public class AlbacornApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlbacornApplication.class, args);
	}

}
