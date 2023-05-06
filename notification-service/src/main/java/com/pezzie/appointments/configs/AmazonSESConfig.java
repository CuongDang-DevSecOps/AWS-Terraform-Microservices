package com.pezzie.appointments.configs;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.pezzie.appointments.configs.properties.AmazonSESProperties;
import io.awspring.cloud.ses.SimpleEmailServiceMailSender;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;

@Configuration
@RequiredArgsConstructor
public class AmazonSESConfig {

    private final AmazonSESProperties amazonSESProperties;

    @Bean
    public AmazonSimpleEmailService amazonSimpleEmailService() {
        var credentials = new BasicAWSCredentials(
                amazonSESProperties.getAccessKey(),
                amazonSESProperties.getSecretKey());
        return AmazonSimpleEmailServiceClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(amazonSESProperties.getRegion())
                .build();
    }

    @Bean
    public MailSender sesMailSender(AmazonSimpleEmailService amazonSimpleEmailService) {
        return new SimpleEmailServiceMailSender(amazonSimpleEmailService);
    }
}
