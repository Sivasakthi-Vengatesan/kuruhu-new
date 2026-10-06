package com.kuruhu.anpr;

import java.io.Serializable;

public class PlateSearchRequest implements Serializable {
    private String plateNumber;
    private String dateFrom;
    private String dateTo;
    private String district;

    public PlateSearchRequest() {}

    public String getPlateNumber() { return this.plateNumber; }
    public void setPlateNumber(String plateNumber) { this.plateNumber = plateNumber; }
    public String getDateFrom() { return this.dateFrom; }
    public void setDateFrom(String dateFrom) { this.dateFrom = dateFrom; }
    public String getDateTo() { return this.dateTo; }
    public void setDateTo(String dateTo) { this.dateTo = dateTo; }
    public String getDistrict() { return this.district; }
    public void setDistrict(String district) { this.district = district; }
}
