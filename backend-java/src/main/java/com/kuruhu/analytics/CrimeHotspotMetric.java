package com.kuruhu.analytics;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "crimehotspotmetric_records")
public class CrimeHotspotMetric implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String gridSquare;
    private String incidentCount;
    private String primaryCrimeType;
    private String riskIndex;

    public CrimeHotspotMetric() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getGridSquare() { return this.gridSquare; }
    public void setGridSquare(String gridSquare) { this.gridSquare = gridSquare; }
    public String getIncidentCount() { return this.incidentCount; }
    public void setIncidentCount(String incidentCount) { this.incidentCount = incidentCount; }
    public String getPrimaryCrimeType() { return this.primaryCrimeType; }
    public void setPrimaryCrimeType(String primaryCrimeType) { this.primaryCrimeType = primaryCrimeType; }
    public String getRiskIndex() { return this.riskIndex; }
    public void setRiskIndex(String riskIndex) { this.riskIndex = riskIndex; }
}
