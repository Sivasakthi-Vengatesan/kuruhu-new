package com.kuruhu.biometrics;

import java.io.Serializable;

public class BiometricMatchResponse implements Serializable {
    private String matchedPersonId;
    private String candidateName;
    private String matchScore;

    public BiometricMatchResponse() {}

    public String getMatchedPersonId() { return this.matchedPersonId; }
    public void setMatchedPersonId(String matchedPersonId) { this.matchedPersonId = matchedPersonId; }
    public String getCandidateName() { return this.candidateName; }
    public void setCandidateName(String candidateName) { this.candidateName = candidateName; }
    public String getMatchScore() { return this.matchScore; }
    public void setMatchScore(String matchScore) { this.matchScore = matchScore; }
}
