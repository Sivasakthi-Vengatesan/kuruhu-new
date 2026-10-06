package com.kuruhu.service;

import com.kuruhu.dto.*;
import java.util.List;
import java.util.Map;

public interface AuthService {
    LoginResponse login(LoginRequest request);
    LoginResponse signup(SignupRequest request);
    UserDTO getCurrentUser();
}
