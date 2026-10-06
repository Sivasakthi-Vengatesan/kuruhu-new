package com.kuruhu.biometrics;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "gaitanalysisrecord_records")
public class GaitAnalysisRecord implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String personId;
    private String strideFrequency;
    private String cadence;
    private String symmetryScore;

    public GaitAnalysisRecord() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getPersonId() { return this.personId; }
    public void setPersonId(String personId) { this.personId = personId; }
    public String getStrideFrequency() { return this.strideFrequency; }
    public void setStrideFrequency(String strideFrequency) { this.strideFrequency = strideFrequency; }
    public String getCadence() { return this.cadence; }
    public void setCadence(String cadence) { this.cadence = cadence; }
    public String getSymmetryScore() { return this.symmetryScore; }
    public void setSymmetryScore(String symmetryScore) { this.symmetryScore = symmetryScore; }
}
