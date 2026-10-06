package com.kuruhu.analytics;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "spatialtemporalmetric_records")
public class SpatialTemporalMetric implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String zoneId;
    private String dayOfWeek;
    private String hourOfDay;
    private String crimeFrequency;

    public SpatialTemporalMetric() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getZoneId() { return this.zoneId; }
    public void setZoneId(String zoneId) { this.zoneId = zoneId; }
    public String getDayOfWeek() { return this.dayOfWeek; }
    public void setDayOfWeek(String dayOfWeek) { this.dayOfWeek = dayOfWeek; }
    public String getHourOfDay() { return this.hourOfDay; }
    public void setHourOfDay(String hourOfDay) { this.hourOfDay = hourOfDay; }
    public String getCrimeFrequency() { return this.crimeFrequency; }
    public void setCrimeFrequency(String crimeFrequency) { this.crimeFrequency = crimeFrequency; }
}
