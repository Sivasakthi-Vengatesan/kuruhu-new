package com.kuruhu.threat;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "threatassessmentreport_records")
public class ThreatAssessmentReport implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String targetArea;
    private String threatProbability;
    private String recommendedDeployment;

    public ThreatAssessmentReport() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getTargetArea() { return this.targetArea; }
    public void setTargetArea(String targetArea) { this.targetArea = targetArea; }
    public String getThreatProbability() { return this.threatProbability; }
    public void setThreatProbability(String threatProbability) { this.threatProbability = threatProbability; }
    public String getRecommendedDeployment() { return this.recommendedDeployment; }
    public void setRecommendedDeployment(String recommendedDeployment) { this.recommendedDeployment = recommendedDeployment; }
}
