package com.kuruhu.security;

import com.kuruhu.dto.LoginRequest;
import com.kuruhu.dto.LoginResponse;
import com.kuruhu.dto.UserDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthenticationService {
    private final JwtTokenProvider jwtTokenProvider;

    public AuthenticationService(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public LoginResponse authenticate(LoginRequest request) {
        String token = jwtTokenProvider.generateToken(request.getIdentifier(), 1L, List.of("ROLE_OFFICER"));
        UserDTO user = UserDTO.builder()
                .id("1")
                .loginIdentifier(request.getIdentifier())
                .displayName("Investigating Officer")
                .role(request.getRole() != null ? request.getRole() : "officer")
                .roles(List.of("ROLE_OFFICER"))
                .permissions(List.of("firs:view", "cases:edit", "ai:access"))
                .district(request.getDistrict() != null ? request.getDistrict() : "Bengaluru City")
                .badgeNumber("KSP-30412")
                .station("Jayanagar PS")
                .isActive(true)
                .build();

        return LoginResponse.builder()
                .token(token)
                .tokenType("Bearer")
                .user(user)
                .requiresVerification(false)
                .build();
    }
}
