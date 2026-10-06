package com.kuruhu.biometrics;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "biometricprofile_records")
public class BiometricProfile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String personId;
    private String fingerprintTemplate;
    private String facialVector;
    private String irisPattern;

    public BiometricProfile() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getPersonId() { return this.personId; }
    public void setPersonId(String personId) { this.personId = personId; }
    public String getFingerprintTemplate() { return this.fingerprintTemplate; }
    public void setFingerprintTemplate(String fingerprintTemplate) { this.fingerprintTemplate = fingerprintTemplate; }
    public String getFacialVector() { return this.facialVector; }
    public void setFacialVector(String facialVector) { this.facialVector = facialVector; }
    public String getIrisPattern() { return this.irisPattern; }
    public void setIrisPattern(String irisPattern) { this.irisPattern = irisPattern; }
}
