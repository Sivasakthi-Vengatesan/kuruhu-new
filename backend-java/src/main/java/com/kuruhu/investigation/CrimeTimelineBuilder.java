package com.kuruhu.investigation;

import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class CrimeTimelineBuilder {
    public List<String> buildChronologicalSequence(Long firId) { return List.of("Incident Occurred", "FIR Registered", "CCTV Collected"); }
}
