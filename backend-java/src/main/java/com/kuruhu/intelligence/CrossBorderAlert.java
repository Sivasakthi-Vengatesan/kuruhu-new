package com.kuruhu.intelligence;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "crossborderalert_records")
public class CrossBorderAlert implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originState;
    private String targetSuspectName;
    private String alertCategory;

    public CrossBorderAlert() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getOriginState() { return this.originState; }
    public void setOriginState(String originState) { this.originState = originState; }
    public String getTargetSuspectName() { return this.targetSuspectName; }
    public void setTargetSuspectName(String targetSuspectName) { this.targetSuspectName = targetSuspectName; }
    public String getAlertCategory() { return this.alertCategory; }
    public void setAlertCategory(String alertCategory) { this.alertCategory = alertCategory; }
}
