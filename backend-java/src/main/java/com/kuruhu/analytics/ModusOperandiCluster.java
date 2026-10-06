package com.kuruhu.analytics;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "modusoperandicluster_records")
public class ModusOperandiCluster implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clusterCode;
    private String patternDescription;
    private String linkedFirNumbers;

    public ModusOperandiCluster() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getClusterCode() { return this.clusterCode; }
    public void setClusterCode(String clusterCode) { this.clusterCode = clusterCode; }
    public String getPatternDescription() { return this.patternDescription; }
    public void setPatternDescription(String patternDescription) { this.patternDescription = patternDescription; }
    public String getLinkedFirNumbers() { return this.linkedFirNumbers; }
    public void setLinkedFirNumbers(String linkedFirNumbers) { this.linkedFirNumbers = linkedFirNumbers; }
}
