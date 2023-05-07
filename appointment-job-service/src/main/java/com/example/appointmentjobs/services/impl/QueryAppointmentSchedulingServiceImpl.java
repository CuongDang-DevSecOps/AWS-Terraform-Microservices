package com.example.appointmentjobs.services.impl;

import com.example.appointmentjobs.clients.AppointmentSchedulingServiceClient;
import com.example.appointmentjobs.services.QueryAppointmentSchedulingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryAppointmentSchedulingServiceImpl implements QueryAppointmentSchedulingService {

    private final AppointmentSchedulingServiceClient appointmentSchedulingServiceClient;

    @Override
    public void proceedOverdueAppointment() {
        var overdueAppointments = appointmentSchedulingServiceClient.fetchOverdueAppointments();

        overdueAppointments.forEach(appointmentInfo -> appointmentSchedulingServiceClient.updateAppointmentStatus());
    }
}
