package com.pezzie.appointments.configs.routes;

import com.pezzie.appointments.handlers.NotificationHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class NotificationTestingRouter {

    @Bean
    public RouterFunction<ServerResponse> appointmentRoutes(NotificationHandler notificationHandler) {
        return route(POST("/api/v1/emails"), notificationHandler::sendMail);
    }
}
