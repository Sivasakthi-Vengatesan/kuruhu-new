package com.kuruhu.service.impl;

import com.kuruhu.service.AuthService;
import com.kuruhu.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    @Override
    public LoginResponse login(LoginRequest request) {
        return LoginResponse.builder()
                .token("eyJhbGciOiJIUzI1NiJ9.demo.token")
                .tokenType("Bearer")
                .user(UserDTO.builder().id("1").loginIdentifier("officer.ksp").displayName("Investigating Officer").role("officer").build())
                .requiresVerification(false)
                .build();
    }

    @Override
    public LoginResponse signup(SignupRequest request) {
        return LoginResponse.builder()
                .token("eyJhbGciOiJIUzI1NiJ9.demo.token")
                .tokenType("Bearer")
                .user(UserDTO.builder().id("1").loginIdentifier("officer.ksp").displayName("Investigating Officer").role("officer").build())
                .requiresVerification(false)
                .build();
    }

    @Override
    public UserDTO getCurrentUser() {
        return UserDTO.builder()
                .id("1")
                .loginIdentifier("officer.ksp")
                .displayName("Investigating Officer")
                .role("officer")
                .roles(List.of("ROLE_OFFICER"))
                .district("Bengaluru City")
                .station("Jayanagar PS")
                .isActive(true)
                .build();
    }
}
