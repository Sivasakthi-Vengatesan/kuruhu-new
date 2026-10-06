package com.kuruhu.forensics;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "forensicreport_records")
public class ForensicReport implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reportNumber;
    private String caseNumber;
    private String examiner;
    private String findings;
    private String specimenType;

    public ForensicReport() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getReportNumber() { return this.reportNumber; }
    public void setReportNumber(String reportNumber) { this.reportNumber = reportNumber; }
    public String getCaseNumber() { return this.caseNumber; }
    public void setCaseNumber(String caseNumber) { this.caseNumber = caseNumber; }
    public String getExaminer() { return this.examiner; }
    public void setExaminer(String examiner) { this.examiner = examiner; }
    public String getFindings() { return this.findings; }
    public void setFindings(String findings) { this.findings = findings; }
    public String getSpecimenType() { return this.specimenType; }
    public void setSpecimenType(String specimenType) { this.specimenType = specimenType; }
}
