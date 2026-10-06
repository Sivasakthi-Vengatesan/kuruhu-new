package com.kuruhu.service.impl;

import com.kuruhu.service.PersonService;
import com.kuruhu.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Override
    public java.util.List<PersonDTO> getAllPersons(int page, int size) {
        return java.util.Collections.emptyList();
    }

    @Override
    public PersonDTO getPersonById(Long id) {
        return PersonDTO.builder()
                .id("1001")
                .name("Ravi Kumar S @ Bullet Ravi")
                .aliases(List.of("Bullet", "Ravi"))
                .age(34)
                .gender("M")
                .role("accused")
                .risk("high")
                .phone("+91 9845012345")
                .address("BTM Layout, Bengaluru")
                .build();
    }

    @Override
    public PersonDTO createPerson(CreatePersonRequest request) {
        return PersonDTO.builder()
                .id("1001")
                .name("Ravi Kumar S @ Bullet Ravi")
                .aliases(List.of("Bullet", "Ravi"))
                .age(34)
                .gender("M")
                .role("accused")
                .risk("high")
                .phone("+91 9845012345")
                .address("BTM Layout, Bengaluru")
                .build();
    }

    @Override
    public PersonDTO updatePerson(Long id, UpdatePersonRequest request) {
        return PersonDTO.builder()
                .id("1001")
                .name("Ravi Kumar S @ Bullet Ravi")
                .aliases(List.of("Bullet", "Ravi"))
                .age(34)
                .gender("M")
                .role("accused")
                .risk("high")
                .phone("+91 9845012345")
                .address("BTM Layout, Bengaluru")
                .build();
    }
}
