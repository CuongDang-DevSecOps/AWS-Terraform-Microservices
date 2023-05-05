package com.example.appointments.services;

import com.example.appointments.dtos.AppointmentInfoDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AppointmentService {

    Flux<AppointmentInfoDTO> fetchAppointments();

    Mono<AppointmentInfoDTO> fetchAppointment(String id);
}
