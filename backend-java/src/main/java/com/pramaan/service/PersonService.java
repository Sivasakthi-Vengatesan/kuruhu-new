package com.pramaan.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pramaan.dto.*;
import com.pramaan.entity.*;
import com.pramaan.exception.ResourceNotFoundException;
import com.pramaan.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private static final Logger log = LoggerFactory.getLogger(PersonService.class);

    private final PersonRepository personRepository;
    private final PersonAliasRepository personAliasRepository;
    private final CasePartyRepository casePartyRepository;
    private final PersonRelationshipRepository personRelationshipRepository;
    private final FirRepository firRepository;
    private final ActivityService activityService;
    private final ObjectMapper objectMapper;

    public PersonService(PersonRepository personRepository, PersonAliasRepository personAliasRepository, CasePartyRepository casePartyRepository, PersonRelationshipRepository personRelationshipRepository, FirRepository firRepository, ActivityService activityService, ObjectMapper objectMapper) {
        this.personRepository = personRepository;
        this.personAliasRepository = personAliasRepository;
        this.casePartyRepository = casePartyRepository;
        this.personRelationshipRepository = personRelationshipRepository;
        this.firRepository = firRepository;
        this.activityService = activityService;
        this.objectMapper = objectMapper;
    }


    @Transactional(readOnly = true)
    public List<PersonDto> getAllPersons(String query, String role) {
        List<Person> persons = personRepository.searchAndFilterPersons(query, role);
        return persons.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PersonDto getPersonById(String idOrCode) {
        Person person = null;
        if (idOrCode.matches("^\\d+$")) {
            person = personRepository.findById(Long.parseLong(idOrCode)).orElse(null);
        }
        if (person == null) {
            person = personRepository.findByPersonCode(idOrCode)
                    .orElseThrow(() -> new ResourceNotFoundException("Person not found with ID/Code: " + idOrCode));
        }
        return mapToDto(person);
    }

    @Transactional
    public PersonDto createPerson(CreatePersonRequest request) {
        OffsetDateTime now = OffsetDateTime.now();
        String personCode = "P-" + (1000 + new Random().nextInt(9000));

        String knownLocsJson = "[]";
        if (request.getKnownLocations() != null) {
            try { knownLocsJson = objectMapper.writeValueAsString(request.getKnownLocations()); } catch (Exception ignored) {}
        }

        String socioJson = null;
        if (request.getSocioDemographics() != null) {
            try { socioJson = objectMapper.writeValueAsString(request.getSocioDemographics()); } catch (Exception ignored) {}
        }

        String behJson = null;
        if (request.getBehavioralProfile() != null) {
            try { behJson = objectMapper.writeValueAsString(request.getBehavioralProfile()); } catch (Exception ignored) {}
        }

        Person person = Person.builder()
                .personCode(personCode)
                .canonicalName(request.getName())
                .ageYears(request.getAge() != null ? request.getAge() : 30)
                .gender(request.getGender() != null ? request.getGender() : "M")
                .primaryRole(request.getRole() != null ? request.getRole().toLowerCase() : "suspect")
                .riskLevel(request.getRisk() != null ? request.getRisk().toLowerCase() : "medium")
                .phone(request.getPhone() != null ? request.getPhone() : "+91 98xx xx0000")
                .address(request.getAddress() != null ? request.getAddress() : "Bengaluru, Karnataka")
                .identifierRef(request.getIdentifier() != null ? request.getIdentifier() : "AAD-XXXX-" + (1000 + new Random().nextInt(9000)))
                .knownLocations(knownLocsJson)
                .socioDemographics(socioJson)
                .behavioralProfile(behJson)
                .lastActivity(now)
                .build();

        person = personRepository.save(person);

        // Add aliases
        if (request.getAliases() != null) {
            for (String a : request.getAliases()) {
                if (StringUtils.hasText(a)) {
                    PersonAlias pa = PersonAlias.builder().person(person).aliasName(a.trim()).build();
                    personAliasRepository.save(pa);
                }
            }
        }

        // Link to FIRs if requested
        if (request.getFirIds() != null) {
            for (String fid : request.getFirIds()) {
                if (fid.matches("^\\d+$")) {
                    Fir fir = firRepository.findById(Long.parseLong(fid)).orElse(null);
                    if (fir != null) {
                        CaseParty cp = CaseParty.builder()
                                .fir(fir)
                                .person(person)
                                .role(person.getPrimaryRole())
                                .notes("Associated during person creation")
                                .build();
                        casePartyRepository.save(cp);
                    }
                }
            }
        }

        activityService.logActivity(null, "Created Person", person.getCanonicalName() + " (" + person.getPrimaryRole() + ")", "person", "Person intelligence profile created");

        return mapToDto(person);
    }

    @Transactional
    public PersonDto updatePerson(String idOrCode, UpdatePersonRequest request) {
        PersonDto existing = getPersonById(idOrCode);
        Person person = personRepository.findById(Long.parseLong(existing.getId()))
                .orElseThrow(() -> new ResourceNotFoundException("Person not found: " + idOrCode));

        if (StringUtils.hasText(request.getName())) person.setCanonicalName(request.getName());
        if (request.getAge() != null) person.setAgeYears(request.getAge());
        if (StringUtils.hasText(request.getGender())) person.setGender(request.getGender());
        if (StringUtils.hasText(request.getRole())) person.setPrimaryRole(request.getRole().toLowerCase());
        if (StringUtils.hasText(request.getRisk())) person.setRiskLevel(request.getRisk().toLowerCase());
        if (StringUtils.hasText(request.getPhone())) person.setPhone(request.getPhone());
        if (StringUtils.hasText(request.getAddress())) person.setAddress(request.getAddress());
        if (StringUtils.hasText(request.getIdentifier())) person.setIdentifierRef(request.getIdentifier());

        if (request.getKnownLocations() != null) {
            try { person.setKnownLocations(objectMapper.writeValueAsString(request.getKnownLocations())); } catch (Exception ignored) {}
        }
        if (request.getSocioDemographics() != null) {
            try { person.setSocioDemographics(objectMapper.writeValueAsString(request.getSocioDemographics())); } catch (Exception ignored) {}
        }
        if (request.getBehavioralProfile() != null) {
            try { person.setBehavioralProfile(objectMapper.writeValueAsString(request.getBehavioralProfile())); } catch (Exception ignored) {}
        }

        person.setLastActivity(OffsetDateTime.now());
        person = personRepository.save(person);

        activityService.logActivity(null, "Updated Person", person.getCanonicalName(), "person", "Person intelligence record modified");

        return mapToDto(person);
    }

    @Transactional
    public void deletePerson(String idOrCode) {
        PersonDto existing = getPersonById(idOrCode);
        personRepository.deleteById(Long.parseLong(existing.getId()));
        activityService.logActivity(null, "Deleted Person", existing.getName(), "person", "Person record removed");
    }

    public PersonDto mapToDto(Person person) {
        List<PersonAlias> aliases = personAliasRepository.findByPersonId(person.getId());
        List<String> aliasNames = aliases.stream().map(PersonAlias::getAliasName).collect(Collectors.toList());

        List<CaseParty> parties = casePartyRepository.findByPersonId(person.getId());
        List<String> firIds = parties.stream().map(p -> String.valueOf(p.getFir().getId())).distinct().collect(Collectors.toList());

        List<String> knownLocs = new ArrayList<>();
        if (StringUtils.hasText(person.getKnownLocations())) {
            try {
                knownLocs = objectMapper.readValue(person.getKnownLocations(), new TypeReference<List<String>>() {});
            } catch (Exception ignored) {}
        }

        SocioDemographicsDto socio = null;
        if (StringUtils.hasText(person.getSocioDemographics())) {
            try { socio = objectMapper.readValue(person.getSocioDemographics(), SocioDemographicsDto.class); } catch (Exception ignored) {}
        }

        BehavioralProfileDto beh = null;
        if (StringUtils.hasText(person.getBehavioralProfile())) {
            try { beh = objectMapper.readValue(person.getBehavioralProfile(), BehavioralProfileDto.class); } catch (Exception ignored) {}
        }

        List<PersonRelationship> rels = personRelationshipRepository.findByPersonId(person.getId());
        List<PersonRelationshipDto> relDtos = rels.stream()
                .map(r -> PersonRelationshipDto.builder()
                        .personId(String.valueOf(r.getRelatedPerson().getId()))
                        .label(r.getRelationshipLabel())
                        .firId(r.getFirReference() != null ? String.valueOf(r.getFirReference().getId()) : "")
                        .verified(r.getIsVerified() != null ? r.getIsVerified() : true)
                        .build())
                .collect(Collectors.toList());

        return PersonDto.builder()
                .id(String.valueOf(person.getId()))
                .name(person.getCanonicalName())
                .aliases(aliasNames)
                .age(person.getAgeYears() != null ? person.getAgeYears() : 30)
                .gender(person.getGender() != null ? person.getGender() : "M")
                .role(person.getPrimaryRole() != null ? person.getPrimaryRole() : "suspect")
                .risk(person.getRiskLevel() != null ? person.getRiskLevel() : "medium")
                .phone(person.getPhone() != null ? person.getPhone() : "+91 98xx xx0000")
                .address(person.getAddress() != null ? person.getAddress() : "Bengaluru, Karnataka")
                .identifier(person.getIdentifierRef() != null ? person.getIdentifierRef() : "ID-" + person.getId())
                .firIds(firIds)
                .knownLocations(knownLocs)
                .socioDemographics(socio)
                .behavioralProfile(beh)
                .relationships(relDtos)
                .lastActivity(person.getLastActivity() != null ? person.getLastActivity().toString() : OffsetDateTime.now().toString())
                .build();
    }
}