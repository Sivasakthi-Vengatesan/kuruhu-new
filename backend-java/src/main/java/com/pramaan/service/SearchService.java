package com.pramaan.service;

import com.pramaan.dto.SearchResponse;
import com.pramaan.dto.SearchResultItem;
import com.pramaan.entity.Fir;
import com.pramaan.entity.LocationRecord;
import com.pramaan.entity.Person;
import com.pramaan.entity.Vehicle;
import com.pramaan.repository.FirRepository;
import com.pramaan.repository.LocationRecordRepository;
import com.pramaan.repository.PersonRepository;
import com.pramaan.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    private final FirRepository firRepository;
    private final PersonRepository personRepository;
    private final VehicleRepository vehicleRepository;
    private final LocationRecordRepository locationRecordRepository;

    public SearchService(FirRepository firRepository, PersonRepository personRepository, VehicleRepository vehicleRepository, LocationRecordRepository locationRecordRepository) {
        this.firRepository = firRepository;
        this.personRepository = personRepository;
        this.vehicleRepository = vehicleRepository;
        this.locationRecordRepository = locationRecordRepository;
    }


    @Transactional(readOnly = true)
    public SearchResponse search(String query) {
        if (!StringUtils.hasText(query)) {
            return getRecentQuickSearchItems();
        }

        String q = query.trim();
        List<SearchResultItem> items = new ArrayList<>();

        // 1. Search FIRs
        List<Fir> firs = firRepository.filterFirs(q, "all", "all", "all");
        for (Fir f : firs) {
            items.add(SearchResultItem.builder()
                    .key("fir-" + f.getId())
                    .kind("FIR")
                    .title("FIR " + f.getFirNumber() + " — " + f.getTitle())
                    .subtitle(f.getStationName() + " · " + f.getInvestigatingOfficer())
                    .href("/workspace/firs/" + f.getId() + "/")
                    .build());
        }

        // 2. Search Persons
        List<Person> persons = personRepository.searchAndFilterPersons(q, "all");
        for (Person p : persons) {
            String aliases = p.getAliases().isEmpty() ? "" : " (" + String.join(", ", p.getAliases().stream().map(a -> a.getAliasName()).toList()) + ")";
            items.add(SearchResultItem.builder()
                    .key("person-" + p.getId())
                    .kind("Person")
                    .title(p.getCanonicalName() + aliases)
                    .subtitle(p.getPrimaryRole() + " · " + (p.getAddress() != null ? p.getAddress() : "Bengaluru"))
                    .href("/workspace/persons/" + p.getId() + "/")
                    .build());
        }

        // 3. Search Vehicles
        List<Vehicle> vehicles = vehicleRepository.searchVehicles(q);
        for (Vehicle v : vehicles) {
            items.add(SearchResultItem.builder()
                    .key("vehicle-" + v.getId())
                    .kind("Vehicle")
                    .title(v.getRegistrationNumber())
                    .subtitle((v.getColor() != null ? v.getColor() : "") + " " + (v.getMake() != null ? v.getMake() : "Vehicle"))
                    .href("/workspace/graph/")
                    .build());
        }

        // 4. Search Locations
        List<LocationRecord> locations = locationRecordRepository.searchLocations(q);
        for (LocationRecord l : locations) {
            items.add(SearchResultItem.builder()
                    .key("location-" + l.getId())
                    .kind("Location")
                    .title(l.getName())
                    .subtitle(l.getArea() + ", " + l.getDistrict())
                    .href("/workspace/graph/")
                    .build());
        }

        return SearchResponse.builder()
                .query(q)
                .totalResults(items.size())
                .items(items)
                .build();
    }

    private SearchResponse getRecentQuickSearchItems() {
        List<SearchResultItem> items = new ArrayList<>();
        List<Fir> firs = firRepository.findAll();
        for (int i = 0; i < Math.min(firs.size(), 4); i++) {
            Fir f = firs.get(i);
            items.add(SearchResultItem.builder()
                    .key("fir-" + f.getId())
                    .kind("FIR")
                    .title("FIR " + f.getFirNumber() + " — " + f.getTitle())
                    .subtitle(f.getStationName() + " · " + f.getInvestigatingOfficer())
                    .href("/workspace/firs/" + f.getId() + "/")
                    .build());
        }

        List<Person> persons = personRepository.findAll();
        for (int i = 0; i < Math.min(persons.size(), 3); i++) {
            Person p = persons.get(i);
            items.add(SearchResultItem.builder()
                    .key("person-" + p.getId())
                    .kind("Person")
                    .title(p.getCanonicalName())
                    .subtitle(p.getPrimaryRole() + " · " + p.getAddress())
                    .href("/workspace/persons/" + p.getId() + "/")
                    .build());
        }

        return SearchResponse.builder()
                .query("")
                .totalResults(items.size())
                .items(items)
                .build();
    }
}