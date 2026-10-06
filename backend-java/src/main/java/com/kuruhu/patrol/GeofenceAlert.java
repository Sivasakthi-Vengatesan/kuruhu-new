package com.kuruhu.patrol;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "geofencealert_records")
public class GeofenceAlert implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fenceName;
    private String entityTracked;
    private String violationType;
    private String triggeredAt;

    public GeofenceAlert() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getFenceName() { return this.fenceName; }
    public void setFenceName(String fenceName) { this.fenceName = fenceName; }
    public String getEntityTracked() { return this.entityTracked; }
    public void setEntityTracked(String entityTracked) { this.entityTracked = entityTracked; }
    public String getViolationType() { return this.violationType; }
    public void setViolationType(String violationType) { this.violationType = violationType; }
    public String getTriggeredAt() { return this.triggeredAt; }
    public void setTriggeredAt(String triggeredAt) { this.triggeredAt = triggeredAt; }
}
