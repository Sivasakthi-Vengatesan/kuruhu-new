package com.pramaan;

import com.pramaan.dto.CreatePersonRequest;
import com.pramaan.dto.PersonDto;
import com.pramaan.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    void testPersonCrudAndSearch() {
        CreatePersonRequest request = CreatePersonRequest.builder()
                .name("Suresh Gowda")
                .aliases(List.of("Surya", "SG"))
                .age(36)
                .gender("M")
                .role("accused")
                .risk("high")
                .phone("+91 98888 77777")
                .address("Jayanagar, Bengaluru")
                .identifier("AAD-XXXX-9911")
                .build();

        PersonDto created = personService.createPerson(request);
        assertNotNull(created.getId());
        assertEquals("Suresh Gowda", created.getName());
        assertEquals("accused", created.getRole());
        assertEquals("high", created.getRisk());
        assertTrue(created.getAliases().contains("Surya"));

        // Search
        List<PersonDto> searchRes = personService.getAllPersons("Surya", "all");
        assertFalse(searchRes.isEmpty());
        assertEquals(created.getId(), searchRes.get(0).getId());
    }
}
