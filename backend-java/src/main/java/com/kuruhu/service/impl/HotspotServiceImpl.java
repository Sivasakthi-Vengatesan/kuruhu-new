package com.kuruhu.service.impl;

import com.kuruhu.service.HotspotService;
import com.kuruhu.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class HotspotServiceImpl implements HotspotService {

    @Override
    public java.util.List<HotspotDTO> getCrimeHotspots() {
        return java.util.Collections.emptyList();
    }

    @Override
    public HotspotDTO createHotspot(HotspotDTO dto) {
        return HotspotDTO.builder().build();
    }
}
