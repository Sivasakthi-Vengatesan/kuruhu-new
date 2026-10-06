package com.kuruhu.threat;

import java.util.List;

public interface ThreatService {
    Object recordThreat(Object param);
    Object analyzeThreatLevel(Object param);
    Object getGangNetwork(Object param);
}
