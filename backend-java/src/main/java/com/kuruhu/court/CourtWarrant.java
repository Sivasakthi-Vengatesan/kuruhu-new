package com.kuruhu.court;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "courtwarrant_records")
public class CourtWarrant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String warrantNumber;
    private String targetPersonId;
    private String warrantType;
    private String validUntil;

    public CourtWarrant() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getWarrantNumber() { return this.warrantNumber; }
    public void setWarrantNumber(String warrantNumber) { this.warrantNumber = warrantNumber; }
    public String getTargetPersonId() { return this.targetPersonId; }
    public void setTargetPersonId(String targetPersonId) { this.targetPersonId = targetPersonId; }
    public String getWarrantType() { return this.warrantType; }
    public void setWarrantType(String warrantType) { this.warrantType = warrantType; }
    public String getValidUntil() { return this.validUntil; }
    public void setValidUntil(String validUntil) { this.validUntil = validUntil; }
}
