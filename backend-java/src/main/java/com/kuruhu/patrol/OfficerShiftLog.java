package com.kuruhu.patrol;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "officershiftlog_records")
public class OfficerShiftLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String officerBadge;
    private String shiftStart;
    private String shiftEnd;
    private String incidentsReported;

    public OfficerShiftLog() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getOfficerBadge() { return this.officerBadge; }
    public void setOfficerBadge(String officerBadge) { this.officerBadge = officerBadge; }
    public String getShiftStart() { return this.shiftStart; }
    public void setShiftStart(String shiftStart) { this.shiftStart = shiftStart; }
    public String getShiftEnd() { return this.shiftEnd; }
    public void setShiftEnd(String shiftEnd) { this.shiftEnd = shiftEnd; }
    public String getIncidentsReported() { return this.incidentsReported; }
    public void setIncidentsReported(String incidentsReported) { this.incidentsReported = incidentsReported; }
}
