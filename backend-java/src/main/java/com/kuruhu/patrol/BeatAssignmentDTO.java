package com.kuruhu.patrol;

import java.io.Serializable;

public class BeatAssignmentDTO implements Serializable {
    private String beatCode;
    private String stationCode;
    private String officerBadge;
    private String shiftType;

    public BeatAssignmentDTO() {}

    public String getBeatCode() { return this.beatCode; }
    public void setBeatCode(String beatCode) { this.beatCode = beatCode; }
    public String getStationCode() { return this.stationCode; }
    public void setStationCode(String stationCode) { this.stationCode = stationCode; }
    public String getOfficerBadge() { return this.officerBadge; }
    public void setOfficerBadge(String officerBadge) { this.officerBadge = officerBadge; }
    public String getShiftType() { return this.shiftType; }
    public void setShiftType(String shiftType) { this.shiftType = shiftType; }
}
