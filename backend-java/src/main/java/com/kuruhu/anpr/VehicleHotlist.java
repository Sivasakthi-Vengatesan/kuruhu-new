package com.kuruhu.anpr;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vehiclehotlist_records")
public class VehicleHotlist implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String plateNumber;
    private String reasonForAlert;
    private String associatedFir;
    private String riskRating;

    public VehicleHotlist() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getPlateNumber() { return this.plateNumber; }
    public void setPlateNumber(String plateNumber) { this.plateNumber = plateNumber; }
    public String getReasonForAlert() { return this.reasonForAlert; }
    public void setReasonForAlert(String reasonForAlert) { this.reasonForAlert = reasonForAlert; }
    public String getAssociatedFir() { return this.associatedFir; }
    public void setAssociatedFir(String associatedFir) { this.associatedFir = associatedFir; }
    public String getRiskRating() { return this.riskRating; }
    public void setRiskRating(String riskRating) { this.riskRating = riskRating; }
}
