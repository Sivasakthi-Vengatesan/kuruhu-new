package com.kuruhu.forensics;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "toxicologyreport_records")
public class ToxicologyReport implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sampleNumber;
    private String substanceFound;
    private String concentrationLevel;
    private String lethalFlag;

    public ToxicologyReport() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getSampleNumber() { return this.sampleNumber; }
    public void setSampleNumber(String sampleNumber) { this.sampleNumber = sampleNumber; }
    public String getSubstanceFound() { return this.substanceFound; }
    public void setSubstanceFound(String substanceFound) { this.substanceFound = substanceFound; }
    public String getConcentrationLevel() { return this.concentrationLevel; }
    public void setConcentrationLevel(String concentrationLevel) { this.concentrationLevel = concentrationLevel; }
    public String getLethalFlag() { return this.lethalFlag; }
    public void setLethalFlag(String lethalFlag) { this.lethalFlag = lethalFlag; }
}
