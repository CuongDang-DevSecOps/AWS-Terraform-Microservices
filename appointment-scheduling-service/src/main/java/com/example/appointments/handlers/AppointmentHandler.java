package com.example.appointments.handlers;

import com.example.appointments.dtos.AppointmentInfoDTO;
import com.example.appointments.services.AppointmentService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public record AppointmentHandler(AppointmentService appointmentService) {

    public Mono<ServerResponse> all(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(appointmentService.fetchAppointments(), AppointmentInfoDTO.class);
    }

    public Mono<ServerResponse> get(ServerRequest serverRequest) {
        var appointmentId = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(appointmentService.fetchAppointment(appointmentId), AppointmentInfoDTO.class);
    }
}
