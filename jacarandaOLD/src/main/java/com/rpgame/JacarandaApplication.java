package com.rpgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "", excludeName = "nameToExclude")
public class JacarandaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JacarandaApplication.class, args);
		
	}

}
