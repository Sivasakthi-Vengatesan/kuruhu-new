package com.kuruhu.service;

import com.kuruhu.dto.*;
import java.util.List;
import java.util.Map;

public interface PoliceStationService {
    java.util.List<Object> getAllStations();
    Object getStationById(Long id);
}
