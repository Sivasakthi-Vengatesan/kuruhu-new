package com.kuruhu.forensics;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "chainofcustodylog_records")
public class ChainOfCustodyLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String evidenceId;
    private String handledByOfficer;
    private String transferredTo;
    private String transferReason;

    public ChainOfCustodyLog() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getEvidenceId() { return this.evidenceId; }
    public void setEvidenceId(String evidenceId) { this.evidenceId = evidenceId; }
    public String getHandledByOfficer() { return this.handledByOfficer; }
    public void setHandledByOfficer(String handledByOfficer) { this.handledByOfficer = handledByOfficer; }
    public String getTransferredTo() { return this.transferredTo; }
    public void setTransferredTo(String transferredTo) { this.transferredTo = transferredTo; }
    public String getTransferReason() { return this.transferReason; }
    public void setTransferReason(String transferReason) { this.transferReason = transferReason; }
}
