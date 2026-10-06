package com.kuruhu.surveillance;

import java.util.List;

public interface SurveillanceService {
    Object registerFeed(Object param);
    Object processDetection(Object param);
    Object analyzeCrowdDensity(Object param);
}
