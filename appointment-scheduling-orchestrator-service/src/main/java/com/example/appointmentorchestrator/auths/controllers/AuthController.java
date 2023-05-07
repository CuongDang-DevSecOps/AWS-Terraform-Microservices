package com.example.appointmentorchestrator.auths.controllers;

import com.example.appointmentorchestrator.auths.dtos.UserSignInRequestDTO;
import com.example.appointmentorchestrator.auths.dtos.UserSignInResponseDTO;
import com.example.appointmentorchestrator.auths.dtos.UserSignUpRequestDTO;
import com.example.appointmentorchestrator.auths.dtos.UserSignUpResponseDTO;
import com.example.appointmentorchestrator.auths.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-up")
    public UserSignUpResponseDTO signUp(@RequestBody UserSignUpRequestDTO request) {
        return authService.signUp(request);
    }

    @PostMapping("/sign-in")
    public UserSignInResponseDTO signIn(@RequestBody UserSignInRequestDTO request) {
        return authService.signIn(request);
    }
}
