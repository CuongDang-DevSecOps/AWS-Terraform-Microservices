package com.example.files.configs.routes;

import com.example.files.handlers.FileHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ImageRouter {

    @Bean
    public RouterFunction<ServerResponse> imageRoutes(FileHandler fileHandler) {
        return route(GET("/api/v1/images/{id}"), fileHandler::get);
    }
}
