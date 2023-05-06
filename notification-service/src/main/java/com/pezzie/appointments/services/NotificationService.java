package com.pezzie.appointments.services;

import com.pezzie.appointments.dtos.EmailRequestDTO;
import reactor.core.publisher.Mono;

public interface NotificationService {

    Mono<Void> sendMail(EmailRequestDTO request);
}
