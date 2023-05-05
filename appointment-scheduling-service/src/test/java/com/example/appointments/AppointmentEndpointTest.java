package com.example.appointments;

import com.example.appointments.handlers.AppointmentHandler;
import com.example.appointments.services.AppointmentService;
import com.example.appointments.configs.routes.AppointmentRouter;
import com.example.appointments.dtos.AppointmentInfoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.ZonedDateTime;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AppointmentEndpointTest {

    private WebTestClient webTestClient;
    private AppointmentService appointmentService;

    @BeforeEach
    void setUp() {
        appointmentService = mock(AppointmentService.class);

        var appointmentHandler = new AppointmentHandler(appointmentService);
        var appointmentRoutes = new AppointmentRouter()
                .appointmentRoutes(appointmentHandler);

        webTestClient = WebTestClient.bindToRouterFunction(appointmentRoutes)
                .build();
    }

    @Test
    void should_ReturnOKAndListOfAppointments_When_GetAppointments() {
        when(appointmentService.fetchAppointments())
                .thenReturn(Flux.fromIterable(DUMMY_APPOINTMENT_LISTING.values()));


        webTestClient.get()
                .uri(uriBuilder -> uriBuilder.path("/api/v1/appointments")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.size()").isEqualTo(2)
        ;
    }

    @Test
    void should_ReturnOKAndAppointmentInfo_When_GetAppointmentById() {
        var testingId = "4659832c-eebc-40a8-b77d-c8f9a9fe6c98";
        when(appointmentService.fetchAppointment(testingId))
                .thenReturn(Mono.just(DUMMY_APPOINTMENT_LISTING.get(testingId)));


        webTestClient.get()
                .uri(uriBuilder -> uriBuilder.path("/api/v1/appointments/" + testingId)
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.title").isEqualTo("Jeff Johnson")
                .jsonPath("$.description").isEqualTo("View Session")
                .jsonPath("$.status").isEqualTo("Confirmed")
        ;
    }

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
}
