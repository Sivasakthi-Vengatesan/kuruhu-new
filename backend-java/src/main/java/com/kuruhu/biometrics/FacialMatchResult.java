package com.kuruhu.biometrics;

public class FacialMatchResult {
    private String personId;
    private String fullName;
    private Double matchConfidence;
    private String sourceImageUri;

    public FacialMatchResult() {}

    public FacialMatchResult(String personId, String fullName, Double matchConfidence) {
        this.personId = personId;
        this.fullName = fullName;
        this.matchConfidence = matchConfidence;
    }

    public String getPersonId() { return personId; }
    public void setPersonId(String personId) { this.personId = personId; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public Double getMatchConfidence() { return matchConfidence; }
    public void setMatchConfidence(Double matchConfidence) { this.matchConfidence = matchConfidence; }
    public String getSourceImageUri() { return sourceImageUri; }
    public void setSourceImageUri(String sourceImageUri) { this.sourceImageUri = sourceImageUri; }
}
