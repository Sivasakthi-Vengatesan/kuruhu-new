package com.kuruhu.biometrics;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "irisscandata_records")
public class IrisScanData implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subjectId;
    private String leftEyeVector;
    private String rightEyeVector;
    private String enrollmentDate;

    public IrisScanData() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getSubjectId() { return this.subjectId; }
    public void setSubjectId(String subjectId) { this.subjectId = subjectId; }
    public String getLeftEyeVector() { return this.leftEyeVector; }
    public void setLeftEyeVector(String leftEyeVector) { this.leftEyeVector = leftEyeVector; }
    public String getRightEyeVector() { return this.rightEyeVector; }
    public void setRightEyeVector(String rightEyeVector) { this.rightEyeVector = rightEyeVector; }
    public String getEnrollmentDate() { return this.enrollmentDate; }
    public void setEnrollmentDate(String enrollmentDate) { this.enrollmentDate = enrollmentDate; }
}
