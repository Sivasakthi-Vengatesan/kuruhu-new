package com.pramaan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class CreateFirRequest {

    @JsonProperty("crime_number")
    private String crimeNumber;

    private String number;

    private String title;

    @JsonProperty("brief_facts")
    private String briefFacts;

    private String summary;

    @JsonProperty("police_station_id")
    private Long policeStationId;

    private String station;

    private String district;

    private String officer;

    private String priority; // critical, high, medium, low

    private String status; // draft, registered, investigating, review, closed

    private List<String> sections;

    private String incidentDate;

    // Wizard optional nested entities
    private String complainantName;
    private String complainantPhone;
    private String complainantAddress;

    public static class PersonEntry {
        public String name;
        public String role;
        public String note;
    }

    public static class EvidenceEntry {
        public String label;
        public String type;
    }

    private List<PersonEntry> persons;
    private List<EvidenceEntry> evidence;


    public CreateFirRequest() {
    }

    public CreateFirRequest(String crimeNumber, String number, String title, String briefFacts, String summary, Long policeStationId, String station, String district, String officer, String priority, String status, List<String> sections, String incidentDate, String complainantName, String complainantPhone, String complainantAddress, List<PersonEntry> persons, List<EvidenceEntry> evidence) {
        this.crimeNumber = crimeNumber;
        this.number = number;
        this.title = title;
        this.briefFacts = briefFacts;
        this.summary = summary;
        this.policeStationId = policeStationId;
        this.station = station;
        this.district = district;
        this.officer = officer;
        this.priority = priority;
        this.status = status;
        this.sections = sections;
        this.incidentDate = incidentDate;
        this.complainantName = complainantName;
        this.complainantPhone = complainantPhone;
        this.complainantAddress = complainantAddress;
        this.persons = persons;
        this.evidence = evidence;
    }

    public String getCrimeNumber() {
        return crimeNumber;
    }

    public void setCrimeNumber(String crimeNumber) {
        this.crimeNumber = crimeNumber;
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

    public String getBriefFacts() {
        return briefFacts;
    }

    public void setBriefFacts(String briefFacts) {
        this.briefFacts = briefFacts;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Long getPoliceStationId() {
        return policeStationId;
    }

    public void setPoliceStationId(Long policeStationId) {
        this.policeStationId = policeStationId;
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

    public String getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(String incidentDate) {
        this.incidentDate = incidentDate;
    }

    public String getComplainantName() {
        return complainantName;
    }

    public void setComplainantName(String complainantName) {
        this.complainantName = complainantName;
    }

    public String getComplainantPhone() {
        return complainantPhone;
    }

    public void setComplainantPhone(String complainantPhone) {
        this.complainantPhone = complainantPhone;
    }

    public String getComplainantAddress() {
        return complainantAddress;
    }

    public void setComplainantAddress(String complainantAddress) {
        this.complainantAddress = complainantAddress;
    }

    public List<PersonEntry> getPersons() {
        return persons;
    }

    public void setPersons(List<PersonEntry> persons) {
        this.persons = persons;
    }

    public List<EvidenceEntry> getEvidence() {
        return evidence;
    }

    public void setEvidence(List<EvidenceEntry> evidence) {
        this.evidence = evidence;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String crimeNumber;
        private String number;
        private String title;
        private String briefFacts;
        private String summary;
        private Long policeStationId;
        private String station;
        private String district;
        private String officer;
        private String priority;
        private String status;
        private List<String> sections;
        private String incidentDate;
        private String complainantName;
        private String complainantPhone;
        private String complainantAddress;
        private List<PersonEntry> persons;
        private List<EvidenceEntry> evidence;

        public Builder crimeNumber(String crimeNumber) {
            this.crimeNumber = crimeNumber;
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
        public Builder briefFacts(String briefFacts) {
            this.briefFacts = briefFacts;
            return this;
        }
        public Builder summary(String summary) {
            this.summary = summary;
            return this;
        }
        public Builder policeStationId(Long policeStationId) {
            this.policeStationId = policeStationId;
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
        public Builder incidentDate(String incidentDate) {
            this.incidentDate = incidentDate;
            return this;
        }
        public Builder complainantName(String complainantName) {
            this.complainantName = complainantName;
            return this;
        }
        public Builder complainantPhone(String complainantPhone) {
            this.complainantPhone = complainantPhone;
            return this;
        }
        public Builder complainantAddress(String complainantAddress) {
            this.complainantAddress = complainantAddress;
            return this;
        }
        public Builder persons(List<PersonEntry> persons) {
            this.persons = persons;
            return this;
        }
        public Builder evidence(List<EvidenceEntry> evidence) {
            this.evidence = evidence;
            return this;
        }

        public CreateFirRequest build() {
            return new CreateFirRequest(this.crimeNumber, this.number, this.title, this.briefFacts, this.summary, this.policeStationId, this.station, this.district, this.officer, this.priority, this.status, this.sections, this.incidentDate, this.complainantName, this.complainantPhone, this.complainantAddress, this.persons, this.evidence);
        }
    }
}