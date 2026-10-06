package com.kuruhu.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "crimepatternclusters")
public class CrimePatternCluster implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patternCode")
    private String patternCode;

    @Column(name = "title")
    private String title;

    @Column(name = "modusOperandi")
    private String modusOperandi;

    @Column(name = "firCount")
    private Integer firCount;

    @Column(name = "suspectProfileSummary")
    private String suspectProfileSummary;

    @Column(name = "identifiedZones")
    private String identifiedZones;

    public CrimePatternCluster() {
    }

    public CrimePatternCluster(Long id, String patternCode, String title, String modusOperandi, Integer firCount, String suspectProfileSummary, String identifiedZones) {
        this.id = id;
        this.patternCode = patternCode;
        this.title = title;
        this.modusOperandi = modusOperandi;
        this.firCount = firCount;
        this.suspectProfileSummary = suspectProfileSummary;
        this.identifiedZones = identifiedZones;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPatternCode() { return patternCode; }
    public void setPatternCode(String patternCode) { this.patternCode = patternCode; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getModusOperandi() { return modusOperandi; }
    public void setModusOperandi(String modusOperandi) { this.modusOperandi = modusOperandi; }

    public Integer getFirCount() { return firCount; }
    public void setFirCount(Integer firCount) { this.firCount = firCount; }

    public String getSuspectProfileSummary() { return suspectProfileSummary; }
    public void setSuspectProfileSummary(String suspectProfileSummary) { this.suspectProfileSummary = suspectProfileSummary; }

    public String getIdentifiedZones() { return identifiedZones; }
    public void setIdentifiedZones(String identifiedZones) { this.identifiedZones = identifiedZones; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String patternCode;
        private String title;
        private String modusOperandi;
        private Integer firCount;
        private String suspectProfileSummary;
        private String identifiedZones;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder patternCode(String patternCode) {
            this.patternCode = patternCode;
            return this;
        }
        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder modusOperandi(String modusOperandi) {
            this.modusOperandi = modusOperandi;
            return this;
        }
        public Builder firCount(Integer firCount) {
            this.firCount = firCount;
            return this;
        }
        public Builder suspectProfileSummary(String suspectProfileSummary) {
            this.suspectProfileSummary = suspectProfileSummary;
            return this;
        }
        public Builder identifiedZones(String identifiedZones) {
            this.identifiedZones = identifiedZones;
            return this;
        }

        public CrimePatternCluster build() {
            return new CrimePatternCluster(this.id, this.patternCode, this.title, this.modusOperandi, this.firCount, this.suspectProfileSummary, this.identifiedZones);
        }
    }
}
