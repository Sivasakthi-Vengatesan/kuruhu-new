package com.kuruhu.service.impl;

import com.kuruhu.service.PatrolRouteService;
import com.kuruhu.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PatrolRouteServiceImpl implements PatrolRouteService {

    @Override
    public java.util.List<PatrolRouteDTO> getPatrolRoutes() {
        return java.util.Collections.emptyList();
    }
}
