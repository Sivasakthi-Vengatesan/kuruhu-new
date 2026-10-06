package com.kuruhu.investigation;

import org.springframework.stereotype.Component;

@Component
public class InvestigationWorkflowEngine {
    public String determineNextStep(String status) { return "COLLECT_FORENSIC_EVIDENCE"; }
}
