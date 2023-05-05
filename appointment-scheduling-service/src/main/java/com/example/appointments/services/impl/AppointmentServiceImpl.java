package com.example.appointments.services.impl;

import com.example.appointments.services.AppointmentService;
import com.example.appointments.dtos.AppointmentInfoDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.ZonedDateTime;
import java.util.Map;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private static final Map<String, AppointmentInfoDTO> DUMMY_APPOINTMENT_LISTING = Map.of(
            "7a05b27e-e437-4dde-bb3d-bc74201ffb7e", new AppointmentInfoDTO(
                    "Emma Lum",
                    "Mini Session",
                    "Pending",
                    ZonedDateTime.now().toOffsetDateTime().toString()),
            "4659832c-eebc-40a8-b77d-c8f9a9fe6c98", new AppointmentInfoDTO(
                    "Jeff Johnson",
                    "View Session",
                    "Confirmed",
                    ZonedDateTime.now().toOffsetDateTime().toString())
    );

    @Override
    public Flux<AppointmentInfoDTO> fetchAppointments() {
        return Flux.fromIterable(DUMMY_APPOINTMENT_LISTING.values());
    }

    @Override
    public Mono<AppointmentInfoDTO> fetchAppointment(String id) {
        return Mono.just(DUMMY_APPOINTMENT_LISTING.get(id));
    }
}
