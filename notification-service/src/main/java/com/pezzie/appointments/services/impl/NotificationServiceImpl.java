package com.pezzie.appointments.services.impl;

import com.pezzie.appointments.dtos.EmailRequestDTO;
import com.pezzie.appointments.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final MailSender sesMailSender;

    @Override
    public Mono<Void> sendMail(EmailRequestDTO request) {
        var simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("noreply@pezzie.com");
        simpleMailMessage.setSubject("Testing Subject");
        simpleMailMessage.setTo(request.toEmail());
        simpleMailMessage.setText("Testing Context");
        sesMailSender.send(simpleMailMessage);
        return Mono.empty();
    }
}
