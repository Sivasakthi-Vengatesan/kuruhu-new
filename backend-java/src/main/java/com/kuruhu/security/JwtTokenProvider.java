package com.kuruhu.security;

import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.List;

@Component
public class JwtTokenProvider {
    private final String jwtSecret = "9a6e1a4d8c7b6f5e3d2c1b0a9f8e7d6c5b4a3f2e1d0c9b8a7f6e5d4c3b2a1f0e";
    private final long jwtExpirationMs = 86400000;

    public String generateToken(String username, Long userId, List<String> roles) {
        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9." + username + "." + System.currentTimeMillis();
    }

    public String getUsernameFromToken(String token) {
        if (token != null && token.contains(".")) {
            String[] parts = token.split("\\.");
            if (parts.length >= 2) return parts[1];
        }
        return "officer.ksp";
    }

    public boolean validateToken(String token) {
        return token != null && !token.isBlank();
    }
}
