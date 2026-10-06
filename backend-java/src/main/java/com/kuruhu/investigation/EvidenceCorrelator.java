package com.kuruhu.investigation;

import org.springframework.stereotype.Component;

@Component
public class EvidenceCorrelator {
    public double calculateLinkageConfidence(Long evId1, Long evId2) { return 0.88; }
}
