package com.pramaan;

import com.pramaan.dto.CreateFirRequest;
import com.pramaan.dto.FirDto;
import com.pramaan.dto.UpdateFirRequest;
import com.pramaan.service.FirService;
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
class FirServiceTest {

    @Autowired
    private FirService firService;

    @Test
    void testFirCrudLifecycle() {
        CreateFirRequest request = CreateFirRequest.builder()
                .crimeNumber("0999/2026")
                .title("Commercial Burglary at Electronics Hub")
                .briefFacts("Night-time break in; duplicate key used.")
                .station("Jayanagar PS")
                .district("Bengaluru City")
                .officer("Insp. Meera Kulkarni")
                .priority("critical")
                .status("investigating")
                .sections(List.of("BNS 303(2)", "BNS 331(4)"))
                .build();

        FirDto created = firService.createFir(request);
        assertNotNull(created.getId());
        assertEquals("0999/2026", created.getNumber());
        assertEquals("Commercial Burglary at Electronics Hub", created.getTitle());
        assertEquals("critical", created.getPriority());
        assertFalse(created.getTimeline().isEmpty());

        // Update FIR
        UpdateFirRequest update = UpdateFirRequest.builder()
                .status("review")
                .priority("high")
                .build();
        FirDto updated = firService.updateFir(created.getId(), update);
        assertEquals("review", updated.getStatus());
        assertEquals("high", updated.getPriority());

        // Get single
        FirDto fetched = firService.getFirById(created.getId());
        assertEquals(created.getNumber(), fetched.getNumber());

        // List
        List<FirDto> list = firService.getAllFirs("Electronics", "all", "all", "all", true);
        assertFalse(list.isEmpty());
    }
}
