package com.pezzie.appointments.handlers;

import com.pezzie.appointments.dtos.EmailRequestDTO;
import com.pezzie.appointments.services.NotificationService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public record NotificationHandler(NotificationService notificationService) {

    public Mono<ServerResponse> sendMail(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(EmailRequestDTO.class)
                .flatMap(request -> ServerResponse.noContent().build(notificationService.sendMail(request)));
    }
}
