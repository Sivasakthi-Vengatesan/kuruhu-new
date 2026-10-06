package com.kuruhu.forensics;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ballisticsanalysis_records")
public class BallisticsAnalysis implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String weaponType;
    private String caliber;
    private String rifling;
    private String matchingCaseNumber;
    private String confidence;

    public BallisticsAnalysis() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getWeaponType() { return this.weaponType; }
    public void setWeaponType(String weaponType) { this.weaponType = weaponType; }
    public String getCaliber() { return this.caliber; }
    public void setCaliber(String caliber) { this.caliber = caliber; }
    public String getRifling() { return this.rifling; }
    public void setRifling(String rifling) { this.rifling = rifling; }
    public String getMatchingCaseNumber() { return this.matchingCaseNumber; }
    public void setMatchingCaseNumber(String matchingCaseNumber) { this.matchingCaseNumber = matchingCaseNumber; }
    public String getConfidence() { return this.confidence; }
    public void setConfidence(String confidence) { this.confidence = confidence; }
}
