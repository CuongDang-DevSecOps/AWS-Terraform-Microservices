package com.example.appointmentjobs.clients;

import com.example.appointmentjobs.dtos.AppointmentInfoDTO;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange("/api/v1/appointments")
public interface AppointmentSchedulingServiceClient {

    @GetExchange("/overdue")
    List<AppointmentInfoDTO> fetchOverdueAppointments();

    @PatchMapping("/status")
    void updateAppointmentStatus();
}
