package com.example.appointmentorchestrator.auths.services.impl;

import com.example.appointmentorchestrator.auths.dtos.UserDetailsImpl;
import com.example.appointmentorchestrator.auths.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        var user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException
                        (String.format("Cannot found user by email: [%s]", email)));

        return UserDetailsImpl.build(user);
    }
}
