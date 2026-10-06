package com.kuruhu.service.impl;

import com.kuruhu.service.OfficerService;
import com.kuruhu.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OfficerServiceImpl implements OfficerService {

    @Override
    public java.util.List<Object> getAllOfficers() {
        return java.util.Collections.emptyList();
    }

    @Override
    public Object getOfficerById(Long id) {
        return new Object();
    }
}
