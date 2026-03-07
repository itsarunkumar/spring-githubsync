package com.arun.devtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DevtrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevtrackerApplication.class, args);
	}

}
