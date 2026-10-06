package com.kuruhu.rag;

import com.kuruhu.dto.CitationDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SourceCitationService {
    public List<CitationDTO> extractCitations(String response, String context) {
        return List.of(CitationDTO.builder().recordId("FIR-101").recordType("FIR").label("FIR 0042/2026").excerpt("BTM Burglary").build());
    }
}
