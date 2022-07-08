package com.org.brm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaAuditing
@EnableScheduling
@SuppressWarnings("unused")
public class BrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrmApplication.class, args);
	}

}
