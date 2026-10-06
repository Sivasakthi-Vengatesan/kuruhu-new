package com.kuruhu.controller;

import com.kuruhu.dto.CreatePersonRequest;
import com.kuruhu.dto.PersonDTO;
import com.kuruhu.dto.UpdatePersonRequest;
import com.kuruhu.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/persons")
@Tag(name = "Person Intelligence", description = "Suspects, victims, witnesses and offender profiling")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> getAllPersons(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size) {
        return ResponseEntity.ok(personService.getAllPersons(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable Long id) {
        return ResponseEntity.ok(personService.getPersonById(id));
    }

    @PostMapping
    public ResponseEntity<PersonDTO> createPerson(@RequestBody CreatePersonRequest request) {
        return ResponseEntity.ok(personService.createPerson(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDTO> updatePerson(@PathVariable Long id, @RequestBody UpdatePersonRequest request) {
        return ResponseEntity.ok(personService.updatePerson(id, request));
    }
}
