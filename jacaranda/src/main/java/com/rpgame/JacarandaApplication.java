package com.rpgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
@EntityScan
@SpringBootApplication(scanBasePackages = {"com.rpgame"} , excludeName = "nameToExclude")
public class JacarandaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JacarandaApplication.class, args);

	}

}
