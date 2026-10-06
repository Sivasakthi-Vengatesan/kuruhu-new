package com.pramaan.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;

@Entity
@Table(name = "crime_pattern_clusters")
public class CrimePatternCluster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cluster_code", unique = true, length = 50)
    private String clusterCode;

    @Column(name = "pattern_name", nullable = false, length = 255)
    private String patternName;

    @Column(nullable = false, length = 100)
    private String category;

    @Column(name = "affected_districts", columnDefinition = "JSONB")
    private String affectedDistricts;

    @Column(name = "fir_count")
    private Integer firCount = 0;

    @Column(name = "suspects_identified")
    private Integer suspectsIdentified = 0;

    @Column(name = "mo_signature", columnDefinition = "TEXT", nullable = false)
    private String moSignature;

    @Column(name = "risk_level", length = 50)
    private String riskLevel = "high"; // critical, high, medium

    @Column(name = "key_insight", columnDefinition = "TEXT", nullable = false)
    private String keyInsight;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private OffsetDateTime createdAt;


    public CrimePatternCluster() {
    }

    public CrimePatternCluster(Long id, String clusterCode, String patternName, String category, String affectedDistricts, Integer firCount, Integer suspectsIdentified, String moSignature, String riskLevel, String keyInsight, OffsetDateTime createdAt) {
        this.id = id;
        this.clusterCode = clusterCode;
        this.patternName = patternName;
        this.category = category;
        this.affectedDistricts = affectedDistricts;
        this.firCount = firCount;
        this.suspectsIdentified = suspectsIdentified;
        this.moSignature = moSignature;
        this.riskLevel = riskLevel;
        this.keyInsight = keyInsight;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClusterCode() {
        return clusterCode;
    }

    public void setClusterCode(String clusterCode) {
        this.clusterCode = clusterCode;
    }

    public String getPatternName() {
        return patternName;
    }

    public void setPatternName(String patternName) {
        this.patternName = patternName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAffectedDistricts() {
        return affectedDistricts;
    }

    public void setAffectedDistricts(String affectedDistricts) {
        this.affectedDistricts = affectedDistricts;
    }

    public Integer getFirCount() {
        return firCount;
    }

    public void setFirCount(Integer firCount) {
        this.firCount = firCount;
    }

    public Integer getSuspectsIdentified() {
        return suspectsIdentified;
    }

    public void setSuspectsIdentified(Integer suspectsIdentified) {
        this.suspectsIdentified = suspectsIdentified;
    }

    public String getMoSignature() {
        return moSignature;
    }

    public void setMoSignature(String moSignature) {
        this.moSignature = moSignature;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getKeyInsight() {
        return keyInsight;
    }

    public void setKeyInsight(String keyInsight) {
        this.keyInsight = keyInsight;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String clusterCode;
        private String patternName;
        private String category;
        private String affectedDistricts;
        private Integer firCount;
        private Integer suspectsIdentified;
        private String moSignature;
        private String riskLevel;
        private String keyInsight;
        private OffsetDateTime createdAt;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder clusterCode(String clusterCode) {
            this.clusterCode = clusterCode;
            return this;
        }
        public Builder patternName(String patternName) {
            this.patternName = patternName;
            return this;
        }
        public Builder category(String category) {
            this.category = category;
            return this;
        }
        public Builder affectedDistricts(String affectedDistricts) {
            this.affectedDistricts = affectedDistricts;
            return this;
        }
        public Builder firCount(Integer firCount) {
            this.firCount = firCount;
            return this;
        }
        public Builder suspectsIdentified(Integer suspectsIdentified) {
            this.suspectsIdentified = suspectsIdentified;
            return this;
        }
        public Builder moSignature(String moSignature) {
            this.moSignature = moSignature;
            return this;
        }
        public Builder riskLevel(String riskLevel) {
            this.riskLevel = riskLevel;
            return this;
        }
        public Builder keyInsight(String keyInsight) {
            this.keyInsight = keyInsight;
            return this;
        }
        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public CrimePatternCluster build() {
            return new CrimePatternCluster(this.id, this.clusterCode, this.patternName, this.category, this.affectedDistricts, this.firCount, this.suspectsIdentified, this.moSignature, this.riskLevel, this.keyInsight, this.createdAt);
        }
    }
}