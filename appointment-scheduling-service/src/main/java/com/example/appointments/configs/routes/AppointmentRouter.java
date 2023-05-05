package com.example.appointments.configs.routes;

import com.example.appointments.handlers.AppointmentHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class AppointmentRouter {

    @Bean
    public RouterFunction<ServerResponse> appointmentRoutes(AppointmentHandler appointmentHandler) {
        return route(GET("/api/v1/appointments"), appointmentHandler::all).
                andRoute(GET("/api/v1/appointments/{id}"), appointmentHandler::get);
    }
}
