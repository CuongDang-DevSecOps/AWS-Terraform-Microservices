package com.pezzie.appointments.configs.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "aws-services.ses")
@Data
public class AmazonSESProperties {

    private String accessKey;
    private String secretKey;
    private String region;
}
