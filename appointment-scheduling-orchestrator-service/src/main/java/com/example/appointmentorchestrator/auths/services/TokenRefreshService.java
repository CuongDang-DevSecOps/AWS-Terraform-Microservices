package com.example.appointmentorchestrator.auths.services;

import com.example.appointmentorchestrator.auths.dtos.TokenRefreshResponseDTO;

public interface TokenRefreshService {

    TokenRefreshResponseDTO createRefreshToken();
}
