package com.kuruhu.court;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "casediaryentry_records")
public class CaseDiaryEntry implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String caseNumber;
    private String dayNumber;
    private String investigationSummary;
    private String entryDate;

    public CaseDiaryEntry() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getCaseNumber() { return this.caseNumber; }
    public void setCaseNumber(String caseNumber) { this.caseNumber = caseNumber; }
    public String getDayNumber() { return this.dayNumber; }
    public void setDayNumber(String dayNumber) { this.dayNumber = dayNumber; }
    public String getInvestigationSummary() { return this.investigationSummary; }
    public void setInvestigationSummary(String investigationSummary) { this.investigationSummary = investigationSummary; }
    public String getEntryDate() { return this.entryDate; }
    public void setEntryDate(String entryDate) { this.entryDate = entryDate; }
}
