package com.kuruhu.analytics;

public class CrimeTrendMetric {
    private String month;
    private String crimeCategory;
    private Long incidentCount;
    private Double rateChangePercentage;

    public CrimeTrendMetric() {}

    public CrimeTrendMetric(String month, String crimeCategory, Long incidentCount, Double rateChangePercentage) {
        this.month = month;
        this.crimeCategory = crimeCategory;
        this.incidentCount = incidentCount;
        this.rateChangePercentage = rateChangePercentage;
    }

    public String getMonth() { return month; }
    public void setMonth(String month) { this.month = month; }
    public String getCrimeCategory() { return crimeCategory; }
    public void setCrimeCategory(String crimeCategory) { this.crimeCategory = crimeCategory; }
    public Long getIncidentCount() { return incidentCount; }
    public void setIncidentCount(Long incidentCount) { this.incidentCount = incidentCount; }
    public Double getRateChangePercentage() { return rateChangePercentage; }
    public void setRateChangePercentage(Double rateChangePercentage) { this.rateChangePercentage = rateChangePercentage; }
}
