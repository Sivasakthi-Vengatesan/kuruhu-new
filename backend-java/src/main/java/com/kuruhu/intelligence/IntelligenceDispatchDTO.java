package com.kuruhu.intelligence;

import java.io.Serializable;

public class IntelligenceDispatchDTO implements Serializable {
    private String dispatchCode;
    private String classification;
    private String summary;
    private String createdDate;

    public IntelligenceDispatchDTO() {}

    public String getDispatchCode() { return this.dispatchCode; }
    public void setDispatchCode(String dispatchCode) { this.dispatchCode = dispatchCode; }
    public String getClassification() { return this.classification; }
    public void setClassification(String classification) { this.classification = classification; }
    public String getSummary() { return this.summary; }
    public void setSummary(String summary) { this.summary = summary; }
    public String getCreatedDate() { return this.createdDate; }
    public void setCreatedDate(String createdDate) { this.createdDate = createdDate; }
}
