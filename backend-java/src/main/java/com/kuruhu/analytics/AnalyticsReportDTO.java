package com.kuruhu.analytics;

import java.io.Serializable;

public class AnalyticsReportDTO implements Serializable {
    private String jurisdiction;
    private String reportMonth;
    private String totalCrimes;
    private String crimeTrends;

    public AnalyticsReportDTO() {}

    public String getJurisdiction() { return this.jurisdiction; }
    public void setJurisdiction(String jurisdiction) { this.jurisdiction = jurisdiction; }
    public String getReportMonth() { return this.reportMonth; }
    public void setReportMonth(String reportMonth) { this.reportMonth = reportMonth; }
    public String getTotalCrimes() { return this.totalCrimes; }
    public void setTotalCrimes(String totalCrimes) { this.totalCrimes = totalCrimes; }
    public String getCrimeTrends() { return this.crimeTrends; }
    public void setCrimeTrends(String crimeTrends) { this.crimeTrends = crimeTrends; }
}
