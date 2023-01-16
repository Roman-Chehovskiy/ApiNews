package test.event.apiNews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class ApiNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiNewsApplication.class, args);

	}

}
