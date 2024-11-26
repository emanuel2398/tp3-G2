package edu.spring.istfi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "edu.spring.istfi.repository")
public class IsTfiApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsTfiApplication.class, args);
	}

}
