package com.kuruhu.workflow;

import java.util.List;

public interface WorkflowService {
    Object startWorkflow(Object param);
    Object transitionStage(Object param);
    Object checkSlaViolations(Object param);
}
