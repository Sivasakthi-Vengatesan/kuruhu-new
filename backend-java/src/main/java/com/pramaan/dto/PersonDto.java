package com.pramaan.dto;


import java.util.ArrayList;
import java.util.List;

public class PersonDto {
    private String id;
    private String name;

    private List<String> aliases = new ArrayList<>();
    
    private int age;
    private String gender; // M, F
    private String role; // accused, suspect, complainant, witness, victim
    private String risk; // high, medium, low
    private String phone;
    private String address;
    private String identifier;

    private List<String> firIds = new ArrayList<>();
    
    private SocioDemographicsDto socioDemographics;
    private BehavioralProfileDto behavioralProfile;

    private List<String> knownLocations = new ArrayList<>();

    private List<PersonRelationshipDto> relationships = new ArrayList<>();
    
    private String lastActivity;


    public PersonDto() {
    }

    public PersonDto(String id, String name, List<String> aliases, int age, String gender, String role, String risk, String phone, String address, String identifier, List<String> firIds, SocioDemographicsDto socioDemographics, BehavioralProfileDto behavioralProfile, List<String> knownLocations, List<PersonRelationshipDto> relationships, String lastActivity) {
        this.id = id;
        this.name = name;
        this.aliases = aliases;
        this.age = age;
        this.gender = gender;
        this.role = role;
        this.risk = risk;
        this.phone = phone;
        this.address = address;
        this.identifier = identifier;
        this.firIds = firIds;
        this.socioDemographics = socioDemographics;
        this.behavioralProfile = behavioralProfile;
        this.knownLocations = knownLocations;
        this.relationships = relationships;
        this.lastActivity = lastActivity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public List<String> getFirIds() {
        return firIds;
    }

    public void setFirIds(List<String> firIds) {
        this.firIds = firIds;
    }

    public SocioDemographicsDto getSocioDemographics() {
        return socioDemographics;
    }

    public void setSocioDemographics(SocioDemographicsDto socioDemographics) {
        this.socioDemographics = socioDemographics;
    }

    public BehavioralProfileDto getBehavioralProfile() {
        return behavioralProfile;
    }

    public void setBehavioralProfile(BehavioralProfileDto behavioralProfile) {
        this.behavioralProfile = behavioralProfile;
    }

    public List<String> getKnownLocations() {
        return knownLocations;
    }

    public void setKnownLocations(List<String> knownLocations) {
        this.knownLocations = knownLocations;
    }

    public List<PersonRelationshipDto> getRelationships() {
        return relationships;
    }

    public void setRelationships(List<PersonRelationshipDto> relationships) {
        this.relationships = relationships;
    }

    public String getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(String lastActivity) {
        this.lastActivity = lastActivity;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String name;
        private List<String> aliases;
        private int age;
        private String gender;
        private String role;
        private String risk;
        private String phone;
        private String address;
        private String identifier;
        private List<String> firIds;
        private SocioDemographicsDto socioDemographics;
        private BehavioralProfileDto behavioralProfile;
        private List<String> knownLocations;
        private List<PersonRelationshipDto> relationships;
        private String lastActivity;

        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder aliases(List<String> aliases) {
            this.aliases = aliases;
            return this;
        }
        public Builder age(int age) {
            this.age = age;
            return this;
        }
        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }
        public Builder role(String role) {
            this.role = role;
            return this;
        }
        public Builder risk(String risk) {
            this.risk = risk;
            return this;
        }
        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }
        public Builder address(String address) {
            this.address = address;
            return this;
        }
        public Builder identifier(String identifier) {
            this.identifier = identifier;
            return this;
        }
        public Builder firIds(List<String> firIds) {
            this.firIds = firIds;
            return this;
        }
        public Builder socioDemographics(SocioDemographicsDto socioDemographics) {
            this.socioDemographics = socioDemographics;
            return this;
        }
        public Builder behavioralProfile(BehavioralProfileDto behavioralProfile) {
            this.behavioralProfile = behavioralProfile;
            return this;
        }
        public Builder knownLocations(List<String> knownLocations) {
            this.knownLocations = knownLocations;
            return this;
        }
        public Builder relationships(List<PersonRelationshipDto> relationships) {
            this.relationships = relationships;
            return this;
        }
        public Builder lastActivity(String lastActivity) {
            this.lastActivity = lastActivity;
            return this;
        }

        public PersonDto build() {
            return new PersonDto(this.id, this.name, this.aliases, this.age, this.gender, this.role, this.risk, this.phone, this.address, this.identifier, this.firIds, this.socioDemographics, this.behavioralProfile, this.knownLocations, this.relationships, this.lastActivity);
        }
    }
}