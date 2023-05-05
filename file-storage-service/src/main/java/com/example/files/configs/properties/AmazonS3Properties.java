package com.example.files.configs.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "aws-services.s3")
@Data
public class AmazonS3Properties {

    private String accessKey;
    private String secretKey;
    private String region;
    private String bucketName;
}
