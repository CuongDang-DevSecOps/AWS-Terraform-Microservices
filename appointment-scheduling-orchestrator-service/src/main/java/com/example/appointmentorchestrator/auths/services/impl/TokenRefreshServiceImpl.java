package com.example.appointmentorchestrator.auths.services.impl;

import com.example.appointmentorchestrator.auths.dtos.TokenRefreshResponseDTO;
import com.example.appointmentorchestrator.auths.services.TokenRefreshService;
import org.springframework.stereotype.Service;

@Service
public class TokenRefreshServiceImpl implements TokenRefreshService {

    @Override
    public TokenRefreshResponseDTO createRefreshToken() {
        return new TokenRefreshResponseDTO("", "Dummy Refresh Token");
    }
}
