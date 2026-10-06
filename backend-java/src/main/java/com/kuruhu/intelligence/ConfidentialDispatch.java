package com.kuruhu.intelligence;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "confidentialdispatch_records")
public class ConfidentialDispatch implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dispatchCode;
    private String sourceUnit;
    private String classificationLevel;
    private String encryptedBody;

    public ConfidentialDispatch() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getDispatchCode() { return this.dispatchCode; }
    public void setDispatchCode(String dispatchCode) { this.dispatchCode = dispatchCode; }
    public String getSourceUnit() { return this.sourceUnit; }
    public void setSourceUnit(String sourceUnit) { this.sourceUnit = sourceUnit; }
    public String getClassificationLevel() { return this.classificationLevel; }
    public void setClassificationLevel(String classificationLevel) { this.classificationLevel = classificationLevel; }
    public String getEncryptedBody() { return this.encryptedBody; }
    public void setEncryptedBody(String encryptedBody) { this.encryptedBody = encryptedBody; }
}
