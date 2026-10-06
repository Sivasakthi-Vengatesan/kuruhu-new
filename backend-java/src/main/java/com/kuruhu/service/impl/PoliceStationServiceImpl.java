package com.kuruhu.service.impl;

import com.kuruhu.service.PoliceStationService;
import com.kuruhu.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PoliceStationServiceImpl implements PoliceStationService {

    @Override
    public java.util.List<Object> getAllStations() {
        return java.util.Collections.emptyList();
    }

    @Override
    public Object getStationById(Long id) {
        return new Object();
    }
}
