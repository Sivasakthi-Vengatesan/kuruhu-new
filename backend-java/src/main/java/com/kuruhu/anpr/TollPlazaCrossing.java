package com.kuruhu.anpr;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tollplazacrossing_records")
public class TollPlazaCrossing implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String plazaId;
    private String laneNumber;
    private String plateNumber;
    private String transitTime;

    public TollPlazaCrossing() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getPlazaId() { return this.plazaId; }
    public void setPlazaId(String plazaId) { this.plazaId = plazaId; }
    public String getLaneNumber() { return this.laneNumber; }
    public void setLaneNumber(String laneNumber) { this.laneNumber = laneNumber; }
    public String getPlateNumber() { return this.plateNumber; }
    public void setPlateNumber(String plateNumber) { this.plateNumber = plateNumber; }
    public String getTransitTime() { return this.transitTime; }
    public void setTransitTime(String transitTime) { this.transitTime = transitTime; }
}
