package com.kuruhu.ai;

import org.springframework.stereotype.Component;

@Component
public class InvestigationQueryProcessor {
    public String processQuery(String rawQuery) {
        return rawQuery != null ? rawQuery.trim() : "";
    }
}
