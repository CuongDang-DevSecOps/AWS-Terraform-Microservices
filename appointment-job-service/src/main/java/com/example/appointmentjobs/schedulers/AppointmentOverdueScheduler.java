package com.example.appointmentjobs.schedulers;

import com.example.appointmentjobs.services.QueryAppointmentSchedulingService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppointmentOverdueScheduler {

    private final QueryAppointmentSchedulingService queryAppointmentSchedulingService;

    @Scheduled(cron = "0 */5 * ? * *")
    public void runEvey5Minutes() {
        queryAppointmentSchedulingService.proceedOverdueAppointment();
    }
}
