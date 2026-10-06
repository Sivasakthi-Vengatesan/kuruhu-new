package com.pramaan.controller;

import com.pramaan.dto.ApiResponse;
import com.pramaan.dto.CreatePersonRequest;
import com.pramaan.dto.PersonDto;
import com.pramaan.dto.UpdatePersonRequest;
import com.pramaan.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/persons")
@Tag(name = "Person Intelligence", description = "Accused, suspect, and complainant intelligence management")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping
    @Operation(summary = "Get persons with search query and role filters")
    public ResponseEntity<List<PersonDto>> getAllPersons(
            @RequestParam(required = false) String query,
            @RequestParam(required = false, defaultValue = "all") String role) {
        return ResponseEntity.ok(personService.getAllPersons(query, role));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get single person intelligence profile by ID or person code")
    public ResponseEntity<PersonDto> getPersonById(@PathVariable String id) {
        return ResponseEntity.ok(personService.getPersonById(id));
    }

    @PostMapping
    @Operation(summary = "Create person profile")
    public ResponseEntity<PersonDto> createPerson(@Valid @RequestBody CreatePersonRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.createPerson(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update person profile")
    public ResponseEntity<PersonDto> updatePerson(@PathVariable String id, @RequestBody UpdatePersonRequest request) {
        return ResponseEntity.ok(personService.updatePerson(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete person profile")
    public ResponseEntity<ApiResponse<Void>> deletePerson(@PathVariable String id) {
        personService.deletePerson(id);
        return ResponseEntity.ok(ApiResponse.of("Person profile deleted successfully", null));
    }
}