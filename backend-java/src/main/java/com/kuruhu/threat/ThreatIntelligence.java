package com.kuruhu.threat;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "threatintelligence_records")
public class ThreatIntelligence implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String threatCode;
    private String groupName;
    private String riskLevel;
    private String threatVector;
    private String assessment;

    public ThreatIntelligence() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getThreatCode() { return this.threatCode; }
    public void setThreatCode(String threatCode) { this.threatCode = threatCode; }
    public String getGroupName() { return this.groupName; }
    public void setGroupName(String groupName) { this.groupName = groupName; }
    public String getRiskLevel() { return this.riskLevel; }
    public void setRiskLevel(String riskLevel) { this.riskLevel = riskLevel; }
    public String getThreatVector() { return this.threatVector; }
    public void setThreatVector(String threatVector) { this.threatVector = threatVector; }
    public String getAssessment() { return this.assessment; }
    public void setAssessment(String assessment) { this.assessment = assessment; }
}
