package com.kuruhu.court;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "chargesheet_records")
public class ChargeSheet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String caseNumber;
    private String accusedPersonIds;
    private String sectionsFiled;
    private String filingOfficerBadge;

    public ChargeSheet() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getCaseNumber() { return this.caseNumber; }
    public void setCaseNumber(String caseNumber) { this.caseNumber = caseNumber; }
    public String getAccusedPersonIds() { return this.accusedPersonIds; }
    public void setAccusedPersonIds(String accusedPersonIds) { this.accusedPersonIds = accusedPersonIds; }
    public String getSectionsFiled() { return this.sectionsFiled; }
    public void setSectionsFiled(String sectionsFiled) { this.sectionsFiled = sectionsFiled; }
    public String getFilingOfficerBadge() { return this.filingOfficerBadge; }
    public void setFilingOfficerBadge(String filingOfficerBadge) { this.filingOfficerBadge = filingOfficerBadge; }
}
