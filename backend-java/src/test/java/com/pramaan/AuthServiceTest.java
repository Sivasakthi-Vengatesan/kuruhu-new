package com.pramaan;

import com.pramaan.dto.AuthResponse;
import com.pramaan.dto.LoginRequest;
import com.pramaan.dto.SignupRequest;
import com.pramaan.service.AuthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class AuthServiceTest {

    @Autowired
    private AuthService authService;

    @Test
    void testSignupAndLogin() {
        SignupRequest signup = SignupRequest.builder()
                .email("test.officer@ksp.gov.in")
                .password("Password@123")
                .name("Test Officer")
                .district("Bengaluru City")
                .role("officer")
                .build();

        AuthResponse signupRes = authService.signup(signup);
        assertNotNull(signupRes.getToken());
        assertNotNull(signupRes.getUser());
        assertEquals("test.officer@ksp.gov.in", signupRes.getUser().getLoginIdentifier());

        LoginRequest login = LoginRequest.builder()
                .identifier("test.officer@ksp.gov.in")
                .credential("Password@123")
                .build();

        AuthResponse loginRes = authService.login(login);
        assertNotNull(loginRes.getToken());
        assertEquals("test.officer@ksp.gov.in", loginRes.getUser().getLoginIdentifier());
    }
}
