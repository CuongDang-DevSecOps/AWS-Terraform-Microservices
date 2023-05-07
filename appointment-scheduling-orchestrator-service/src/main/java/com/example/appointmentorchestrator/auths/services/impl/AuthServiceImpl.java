package com.example.appointmentorchestrator.auths.services.impl;

import com.example.appointmentorchestrator.auths.JsonWebTokenHelper;
import com.example.appointmentorchestrator.auths.dtos.UserSignInRequestDTO;
import com.example.appointmentorchestrator.auths.dtos.UserSignInResponseDTO;
import com.example.appointmentorchestrator.auths.dtos.UserSignUpRequestDTO;
import com.example.appointmentorchestrator.auths.dtos.UserSignUpResponseDTO;
import com.example.appointmentorchestrator.auths.entities.User;
import com.example.appointmentorchestrator.auths.enums.RoleType;
import com.example.appointmentorchestrator.auths.enums.UserStatus;
import com.example.appointmentorchestrator.auths.exceptions.AuthException;
import com.example.appointmentorchestrator.auths.repositories.RoleRepository;
import com.example.appointmentorchestrator.auths.repositories.UserRepository;
import com.example.appointmentorchestrator.auths.services.AuthService;
import com.example.appointmentorchestrator.auths.services.TokenRefreshService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JsonWebTokenHelper jsonWebTokenHelper;
    private final TokenRefreshService tokenRefreshService;

    @Override
    public UserSignUpResponseDTO signUp(UserSignUpRequestDTO request) {

        var isExistingUser = userRepository.existsByEmail(request.email());

        if (Boolean.TRUE.equals(isExistingUser)) {
            throw new AuthException("User has already registered before.");
        }

        var user = new User();
        user.setUserId(UUID.randomUUID());
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setStatus(UserStatus.CREATED);

        // only allow user register
        var role = roleRepository.findByName(RoleType.USER)
                .orElseThrow(() -> new AuthException(String.format("Cannot found role: [%s]", RoleType.USER)));
        var roles = Set.of(role);

        user.setRoles(roles);
        userRepository.save(user);

        return new UserSignUpResponseDTO("User registered successfully!");
    }

    @Override
    public UserSignInResponseDTO signIn(UserSignInRequestDTO request) {

        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        var accessToken = jsonWebTokenHelper.generateJwtToken(authentication);
        var refreshTokenResponse = tokenRefreshService.createRefreshToken();

        return new UserSignInResponseDTO(accessToken, refreshTokenResponse.refreshToken());
    }
}
