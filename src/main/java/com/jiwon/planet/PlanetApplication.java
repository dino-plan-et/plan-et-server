package com.jiwon.planet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PlanetApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanetApplication.class, args);
	}

}
