package com.kuruhu.service;

import com.kuruhu.dto.*;
import java.util.List;
import java.util.Map;

public interface PersonService {
    java.util.List<PersonDTO> getAllPersons(int page, int size);
    PersonDTO getPersonById(Long id);
    PersonDTO createPerson(CreatePersonRequest request);
    PersonDTO updatePerson(Long id, UpdatePersonRequest request);
}
