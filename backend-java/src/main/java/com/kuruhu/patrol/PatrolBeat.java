package com.kuruhu.patrol;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "patrolbeat_records")
public class PatrolBeat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String beatCode;
    private String stationCode;
    private String assignedOfficerBadge;
    private String shiftType;

    public PatrolBeat() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getBeatCode() { return this.beatCode; }
    public void setBeatCode(String beatCode) { this.beatCode = beatCode; }
    public String getStationCode() { return this.stationCode; }
    public void setStationCode(String stationCode) { this.stationCode = stationCode; }
    public String getAssignedOfficerBadge() { return this.assignedOfficerBadge; }
    public void setAssignedOfficerBadge(String assignedOfficerBadge) { this.assignedOfficerBadge = assignedOfficerBadge; }
    public String getShiftType() { return this.shiftType; }
    public void setShiftType(String shiftType) { this.shiftType = shiftType; }
}
