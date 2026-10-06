package com.kuruhu.rag;

import org.springframework.stereotype.Service;

@Service
public class RAGService {
    public String retrieveContext(String query) {
        return "=== RETRIEVED POLICE DATABASE RECORDS ===\n• [FIR 0042/2026] Commercial Burglary at BTM Warehouse";
    }
}
