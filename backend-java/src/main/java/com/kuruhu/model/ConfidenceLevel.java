package com.kuruhu.model;

import java.io.Serializable;

public class ConfidenceLevel implements Serializable {
    private Double percentage;
    private String rating;
    private String modelConfidence;

    public ConfidenceLevel() {}

    public ConfidenceLevel(Double percentage, String rating, String modelConfidence) {
        this.percentage = percentage;
        this.rating = rating;
        this.modelConfidence = modelConfidence;
    }

    public Double getPercentage() { return percentage; }
    public void setPercentage(Double percentage) { this.percentage = percentage; }

    public String getRating() { return rating; }
    public void setRating(String rating) { this.rating = rating; }

    public String getModelConfidence() { return modelConfidence; }
    public void setModelConfidence(String modelConfidence) { this.modelConfidence = modelConfidence; }
}
