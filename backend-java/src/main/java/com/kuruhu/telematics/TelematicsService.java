package com.kuruhu.telematics;

import java.util.List;

public interface TelematicsService {
    Object recordGpsPing(Object param);
    Object checkSpeedViolations(Object param);
    Object getRouteHistory(Object param);
}
