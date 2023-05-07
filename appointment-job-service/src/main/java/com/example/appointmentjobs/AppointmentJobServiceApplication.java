package com.example.appointmentjobs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AppointmentJobServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppointmentJobServiceApplication.class, args);
	}

}
