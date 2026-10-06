package com.kuruhu.court;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bailapplication_records")
public class BailApplication implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String caseNumber;
    private String applicantName;
    private String bailStatus;
    private String suretiesDetails;

    public BailApplication() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getCaseNumber() { return this.caseNumber; }
    public void setCaseNumber(String caseNumber) { this.caseNumber = caseNumber; }
    public String getApplicantName() { return this.applicantName; }
    public void setApplicantName(String applicantName) { this.applicantName = applicantName; }
    public String getBailStatus() { return this.bailStatus; }
    public void setBailStatus(String bailStatus) { this.bailStatus = bailStatus; }
    public String getSuretiesDetails() { return this.suretiesDetails; }
    public void setSuretiesDetails(String suretiesDetails) { this.suretiesDetails = suretiesDetails; }
}
