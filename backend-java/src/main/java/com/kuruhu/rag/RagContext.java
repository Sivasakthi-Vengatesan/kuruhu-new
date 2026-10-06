package com.kuruhu.rag;

import com.kuruhu.dto.CitationDTO;
import java.util.List;

public class RagContext {
    private String formattedContext;
    private List<CitationDTO> citations;

    public RagContext() {}
    public RagContext(String formattedContext, List<CitationDTO> citations) {
        this.formattedContext = formattedContext;
        this.citations = citations;
    }
    public String getFormattedContext() { return formattedContext; }
    public void setFormattedContext(String formattedContext) { this.formattedContext = formattedContext; }
    public List<CitationDTO> getCitations() { return citations; }
    public void setCitations(List<CitationDTO> citations) { this.citations = citations; }
}
