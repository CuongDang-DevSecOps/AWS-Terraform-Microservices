package com.example.appointmentorchestrator.auths;

import com.example.appointmentorchestrator.auths.dtos.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JsonWebTokenHelper {

    public String generateJwtToken(Authentication authentication) {

        var userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        return "Dummy JWT " + userPrincipal.getUserId();
    }
}
