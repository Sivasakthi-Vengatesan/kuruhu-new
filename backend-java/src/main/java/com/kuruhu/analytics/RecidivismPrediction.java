package com.kuruhu.analytics;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "recidivismprediction_records")
public class RecidivismPrediction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String personId;
    private String criminalHistoryScore;
    private String recidivismScore;

    public RecidivismPrediction() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getPersonId() { return this.personId; }
    public void setPersonId(String personId) { this.personId = personId; }
    public String getCriminalHistoryScore() { return this.criminalHistoryScore; }
    public void setCriminalHistoryScore(String criminalHistoryScore) { this.criminalHistoryScore = criminalHistoryScore; }
    public String getRecidivismScore() { return this.recidivismScore; }
    public void setRecidivismScore(String recidivismScore) { this.recidivismScore = recidivismScore; }
}
