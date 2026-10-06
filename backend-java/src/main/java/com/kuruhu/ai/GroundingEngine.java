package com.kuruhu.ai;

import org.springframework.stereotype.Component;

@Component
public class GroundingEngine {
    public boolean verifyFactAgainstContext(String statement, String context) {
        return context != null && context.contains(statement);
    }
}
