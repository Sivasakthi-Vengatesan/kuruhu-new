package com.kuruhu.service;

import com.kuruhu.dto.*;
import java.util.List;
import java.util.Map;

public interface UserService {
    java.util.List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
}
