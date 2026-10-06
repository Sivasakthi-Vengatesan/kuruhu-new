package com.kuruhu.service;

import com.kuruhu.dto.*;
import java.util.List;
import java.util.Map;

public interface HotspotService {
    java.util.List<HotspotDTO> getCrimeHotspots();
    HotspotDTO createHotspot(HotspotDTO dto);
}
