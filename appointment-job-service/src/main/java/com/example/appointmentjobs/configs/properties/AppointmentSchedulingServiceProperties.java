package com.example.appointmentjobs.configs.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "appointment-scheduling-service")
@Data
public class AppointmentSchedulingServiceProperties {

    private String baseUrl;
}
