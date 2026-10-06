package com.pramaan.dto;


import java.util.ArrayList;
import java.util.List;

public class FirDto {
    private String id;
    private String number;
    private String title;
    private String summary;
    private String station;
    private String district;
    private String officer;
    private String priority; // critical, high, medium, low
    private String status; // draft, registered, investigating, review, closed

    private List<String> sections = new ArrayList<>();
    
    private String registeredAt;
    private String updatedAt;

    private List<String> personIds = new ArrayList<>();

    private List<String> evidenceIds = new ArrayList<>();

    private List<String> vehicleIds = new ArrayList<>();

    private List<String> locationIds = new ArrayList<>();
    
    private int relationshipCount;

    private List<String> aiFindingIds = new ArrayList<>();

    private List<FirTimelineDto> timeline = new ArrayList<>();


    public FirDto() {
    }

    public FirDto(String id, String number, String title, String summary, String station, String district, String officer, String priority, String status, List<String> sections, String registeredAt, String updatedAt, List<String> personIds, List<String> evidenceIds, List<String> vehicleIds, List<String> locationIds, int relationshipCount, List<String> aiFindingIds, List<FirTimelineDto> timeline) {
        this.id = id;
        this.number = number;
        this.title = title;
        this.summary = summary;
        this.station = station;
        this.district = district;
        this.officer = officer;
        this.priority = priority;
        this.status = status;
        this.sections = sections;
        this.registeredAt = registeredAt;
        this.updatedAt = updatedAt;
        this.personIds = personIds;
        this.evidenceIds = evidenceIds;
        this.vehicleIds = vehicleIds;
        this.locationIds = locationIds;
        this.relationshipCount = relationshipCount;
        this.aiFindingIds = aiFindingIds;
        this.timeline = timeline;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getOfficer() {
        return officer;
    }

    public void setOfficer(String officer) {
        this.officer = officer;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getSections() {
        return sections;
    }

    public void setSections(List<String> sections) {
        this.sections = sections;
    }

    public String getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(String registeredAt) {
        this.registeredAt = registeredAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<String> getPersonIds() {
        return personIds;
    }

    public void setPersonIds(List<String> personIds) {
        this.personIds = personIds;
    }

    public List<String> getEvidenceIds() {
        return evidenceIds;
    }

    public void setEvidenceIds(List<String> evidenceIds) {
        this.evidenceIds = evidenceIds;
    }

    public List<String> getVehicleIds() {
        return vehicleIds;
    }

    public void setVehicleIds(List<String> vehicleIds) {
        this.vehicleIds = vehicleIds;
    }

    public List<String> getLocationIds() {
        return locationIds;
    }

    public void setLocationIds(List<String> locationIds) {
        this.locationIds = locationIds;
    }

    public int getRelationshipCount() {
        return relationshipCount;
    }

    public void setRelationshipCount(int relationshipCount) {
        this.relationshipCount = relationshipCount;
    }

    public List<String> getAiFindingIds() {
        return aiFindingIds;
    }

    public void setAiFindingIds(List<String> aiFindingIds) {
        this.aiFindingIds = aiFindingIds;
    }

    public List<FirTimelineDto> getTimeline() {
        return timeline;
    }

    public void setTimeline(List<FirTimelineDto> timeline) {
        this.timeline = timeline;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String number;
        private String title;
        private String summary;
        private String station;
        private String district;
        private String officer;
        private String priority;
        private String status;
        private List<String> sections;
        private String registeredAt;
        private String updatedAt;
        private List<String> personIds;
        private List<String> evidenceIds;
        private List<String> vehicleIds;
        private List<String> locationIds;
        private int relationshipCount;
        private List<String> aiFindingIds;
        private List<FirTimelineDto> timeline;

        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder number(String number) {
            this.number = number;
            return this;
        }
        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder summary(String summary) {
            this.summary = summary;
            return this;
        }
        public Builder station(String station) {
            this.station = station;
            return this;
        }
        public Builder district(String district) {
            this.district = district;
            return this;
        }
        public Builder officer(String officer) {
            this.officer = officer;
            return this;
        }
        public Builder priority(String priority) {
            this.priority = priority;
            return this;
        }
        public Builder status(String status) {
            this.status = status;
            return this;
        }
        public Builder sections(List<String> sections) {
            this.sections = sections;
            return this;
        }
        public Builder registeredAt(String registeredAt) {
            this.registeredAt = registeredAt;
            return this;
        }
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }
        public Builder personIds(List<String> personIds) {
            this.personIds = personIds;
            return this;
        }
        public Builder evidenceIds(List<String> evidenceIds) {
            this.evidenceIds = evidenceIds;
            return this;
        }
        public Builder vehicleIds(List<String> vehicleIds) {
            this.vehicleIds = vehicleIds;
            return this;
        }
        public Builder locationIds(List<String> locationIds) {
            this.locationIds = locationIds;
            return this;
        }
        public Builder relationshipCount(int relationshipCount) {
            this.relationshipCount = relationshipCount;
            return this;
        }
        public Builder aiFindingIds(List<String> aiFindingIds) {
            this.aiFindingIds = aiFindingIds;
            return this;
        }
        public Builder timeline(List<FirTimelineDto> timeline) {
            this.timeline = timeline;
            return this;
        }

        public FirDto build() {
            return new FirDto(this.id, this.number, this.title, this.summary, this.station, this.district, this.officer, this.priority, this.status, this.sections, this.registeredAt, this.updatedAt, this.personIds, this.evidenceIds, this.vehicleIds, this.locationIds, this.relationshipCount, this.aiFindingIds, this.timeline);
        }
    }
}