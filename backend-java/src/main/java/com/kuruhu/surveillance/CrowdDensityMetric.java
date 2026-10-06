package com.kuruhu.surveillance;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "crowddensitymetric_records")
public class CrowdDensityMetric implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String locationId;
    private String estimatedHeadcount;
    private String congestionIndex;

    public CrowdDensityMetric() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getLocationId() { return this.locationId; }
    public void setLocationId(String locationId) { this.locationId = locationId; }
    public String getEstimatedHeadcount() { return this.estimatedHeadcount; }
    public void setEstimatedHeadcount(String estimatedHeadcount) { this.estimatedHeadcount = estimatedHeadcount; }
    public String getCongestionIndex() { return this.congestionIndex; }
    public void setCongestionIndex(String congestionIndex) { this.congestionIndex = congestionIndex; }
}
