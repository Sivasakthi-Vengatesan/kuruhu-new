package com.kuruhu.forensics;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "dnaprofile_records")
public class DnaProfile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sampleId;
    private String alleleString;
    private String matchProbability;
    private String sourcePersonId;

    public DnaProfile() {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getSampleId() { return this.sampleId; }
    public void setSampleId(String sampleId) { this.sampleId = sampleId; }
    public String getAlleleString() { return this.alleleString; }
    public void setAlleleString(String alleleString) { this.alleleString = alleleString; }
    public String getMatchProbability() { return this.matchProbability; }
    public void setMatchProbability(String matchProbability) { this.matchProbability = matchProbability; }
    public String getSourcePersonId() { return this.sourcePersonId; }
    public void setSourcePersonId(String sourcePersonId) { this.sourcePersonId = sourcePersonId; }
}
