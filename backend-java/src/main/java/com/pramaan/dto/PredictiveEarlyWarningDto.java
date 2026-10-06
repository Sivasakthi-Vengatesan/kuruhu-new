package com.pramaan.dto;


public class PredictiveEarlyWarningDto {
    private String id;
    private String title;
    private String description;
    private String district;
    private String riskCategory;
    private double confidence;
    private String recommendedAction;
    private String createdAt;


    public PredictiveEarlyWarningDto() {
    }

    public PredictiveEarlyWarningDto(String id, String title, String description, String district, String riskCategory, double confidence, String recommendedAction, String createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.district = district;
        this.riskCategory = riskCategory;
        this.confidence = confidence;
        this.recommendedAction = recommendedAction;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    public String getRecommendedAction() {
        return recommendedAction;
    }

    public void setRecommendedAction(String recommendedAction) {
        this.recommendedAction = recommendedAction;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String title;
        private String description;
        private String district;
        private String riskCategory;
        private double confidence;
        private String recommendedAction;
        private String createdAt;

        public Builder id(String id) {
            this.id = id;
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
        public Builder confidence(double confidence) {
            this.confidence = confidence;
            return this;
        }
        public Builder recommendedAction(String recommendedAction) {
            this.recommendedAction = recommendedAction;
            return this;
        }
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public PredictiveEarlyWarningDto build() {
            return new PredictiveEarlyWarningDto(this.id, this.title, this.description, this.district, this.riskCategory, this.confidence, this.recommendedAction, this.createdAt);
        }
    }
}