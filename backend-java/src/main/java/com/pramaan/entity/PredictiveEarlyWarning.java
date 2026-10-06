package com.pramaan.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "predictive_early_warnings")
public class PredictiveEarlyWarning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "warning_code", unique = true, length = 50)
    private String warningCode;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(nullable = false, length = 150)
    private String district;

    @Column(name = "risk_category", nullable = false, length = 100)
    private String riskCategory;

    @Column(precision = 4, scale = 3)
    private BigDecimal confidence = new BigDecimal("0.900");

    @Column(name = "recommended_action", columnDefinition = "TEXT", nullable = false)
    private String recommendedAction;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private OffsetDateTime createdAt;


    public PredictiveEarlyWarning() {
    }

    public PredictiveEarlyWarning(Long id, String warningCode, String title, String description, String district, String riskCategory, BigDecimal confidence, String recommendedAction, OffsetDateTime createdAt) {
        this.id = id;
        this.warningCode = warningCode;
        this.title = title;
        this.description = description;
        this.district = district;
        this.riskCategory = riskCategory;
        this.confidence = confidence;
        this.recommendedAction = recommendedAction;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWarningCode() {
        return warningCode;
    }

    public void setWarningCode(String warningCode) {
        this.warningCode = warningCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(String riskCategory) {
        this.riskCategory = riskCategory;
    }

    public BigDecimal getConfidence() {
        return confidence;
    }

    public void setConfidence(BigDecimal confidence) {
        this.confidence = confidence;
    }

    public String getRecommendedAction() {
        return recommendedAction;
    }

    public void setRecommendedAction(String recommendedAction) {
        this.recommendedAction = recommendedAction;
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
        private String warningCode;
        private String title;
        private String description;
        private String district;
        private String riskCategory;
        private BigDecimal confidence;
        private String recommendedAction;
        private OffsetDateTime createdAt;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder warningCode(String warningCode) {
            this.warningCode = warningCode;
            return this;
        }
        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder description(String description) {
            this.description = description;
            return this;
        }
        public Builder district(String district) {
            this.district = district;
            return this;
        }
        public Builder riskCategory(String riskCategory) {
            this.riskCategory = riskCategory;
            return this;
        }
        public Builder confidence(BigDecimal confidence) {
            this.confidence = confidence;
            return this;
        }
        public Builder recommendedAction(String recommendedAction) {
            this.recommendedAction = recommendedAction;
            return this;
        }
        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public PredictiveEarlyWarning build() {
            return new PredictiveEarlyWarning(this.id, this.warningCode, this.title, this.description, this.district, this.riskCategory, this.confidence, this.recommendedAction, this.createdAt);
        }
    }
}