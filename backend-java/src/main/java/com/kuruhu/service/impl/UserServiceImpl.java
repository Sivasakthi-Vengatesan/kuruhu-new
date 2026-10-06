package com.kuruhu.service.impl;

import com.kuruhu.service.UserService;
import com.kuruhu.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Override
    public java.util.List<UserDTO> getAllUsers() {
        return java.util.Collections.emptyList();
    }

    @Override
    public UserDTO getUserById(Long id) {
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
