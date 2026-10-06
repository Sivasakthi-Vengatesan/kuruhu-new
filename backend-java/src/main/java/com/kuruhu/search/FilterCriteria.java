package com.kuruhu.search;

public class FilterCriteria {
    private String district;
    private String status;
    private String priority;

    public FilterCriteria() {}
    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }
}
