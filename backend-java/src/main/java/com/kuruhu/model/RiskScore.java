package com.kuruhu.model;

import java.io.Serializable;

public class RiskScore implements Serializable {
    private Double score;
    private String level;
    private String rationale;
    private java.util.List<String> contributingFactors;

    public RiskScore() {}

    public RiskScore(Double score, String level, String rationale, java.util.List<String> contributingFactors) {
        this.score = score;
        this.level = level;
        this.rationale = rationale;
        this.contributingFactors = contributingFactors;
    }

    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }

    public String getRationale() { return rationale; }
    public void setRationale(String rationale) { this.rationale = rationale; }

    public java.util.List<String> getContributingFactors() { return contributingFactors; }
    public void setContributingFactors(java.util.List<String> contributingFactors) { this.contributingFactors = contributingFactors; }
}
