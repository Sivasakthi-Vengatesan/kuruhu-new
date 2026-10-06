package com.kuruhu.analytics;

import java.util.List;

public interface PredictiveAnalyticsService {
    Object predictHotspots(Object param);
    Object calculateRecidivism(Object param);
    Object clusterModusOperandi(Object param);
}
