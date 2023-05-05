package com.example.files.configs;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.example.files.configs.properties.AmazonS3Properties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AmazonS3Config {

    private final AmazonS3Properties amazonS3Properties;

    @Bean
    public AmazonS3 s3Client() {
        var credentials = new BasicAWSCredentials(
                amazonS3Properties.getAccessKey(),
                amazonS3Properties.getSecretKey()
        );
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(amazonS3Properties.getRegion())
                .build();
    }
}
