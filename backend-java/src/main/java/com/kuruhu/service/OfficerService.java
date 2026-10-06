package com.kuruhu.service;

import com.kuruhu.dto.*;
import java.util.List;
import java.util.Map;

public interface OfficerService {
    java.util.List<Object> getAllOfficers();
    Object getOfficerById(Long id);
}
