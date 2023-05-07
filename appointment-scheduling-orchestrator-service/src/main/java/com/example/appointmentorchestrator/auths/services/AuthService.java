package com.example.appointmentorchestrator.auths.services;

import com.example.appointmentorchestrator.auths.dtos.UserSignInRequestDTO;
import com.example.appointmentorchestrator.auths.dtos.UserSignInResponseDTO;
import com.example.appointmentorchestrator.auths.dtos.UserSignUpRequestDTO;
import com.example.appointmentorchestrator.auths.dtos.UserSignUpResponseDTO;

public interface AuthService {

    UserSignUpResponseDTO signUp(UserSignUpRequestDTO request);

    UserSignInResponseDTO signIn(UserSignInRequestDTO request);
}
