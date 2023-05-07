package com.example.appointmentjobs.configs;

import com.example.appointmentjobs.clients.AppointmentSchedulingServiceClient;
import com.example.appointmentjobs.configs.properties.AppointmentSchedulingServiceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ServiceClientConfig {

    @Bean
    public AppointmentSchedulingServiceClient appointmentSchedulingServiceClient(
            AppointmentSchedulingServiceProperties properties) {

        var webClient = WebClient.builder()
                .baseUrl(properties.getBaseUrl())
                .build();

        var proxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient))
                        .build();

        return proxyFactory.createClient(AppointmentSchedulingServiceClient.class);
    }
}
