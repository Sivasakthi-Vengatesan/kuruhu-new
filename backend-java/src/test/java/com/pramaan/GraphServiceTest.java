package com.pramaan;

import com.pramaan.dto.CreateFirRequest;
import com.pramaan.dto.CreatePersonRequest;
import com.pramaan.dto.DashboardSummaryDto;
import com.pramaan.dto.GraphResponse;
import com.pramaan.service.DashboardService;
import com.pramaan.service.FirService;
import com.pramaan.service.GraphService;
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
class GraphServiceTest {

    @Autowired
    private GraphService graphService;

    @Autowired
    private FirService firService;

    @Autowired
    private PersonService personService;

    @Autowired
    private DashboardService dashboardService;

    @Test
    void testGraphAndDashboardMetrics() {
        firService.createFir(CreateFirRequest.builder()
                .crimeNumber("0101/2026")
                .title("Test FIR Graph")
                .briefFacts("Test summary for graph linkages")
                .station("Jayanagar PS")
                .priority("high")
                .status("investigating")
                .build());

        personService.createPerson(CreatePersonRequest.builder()
                .name("Graph Test Person")
                .role("suspect")
                .risk("medium")
                .build());

        GraphResponse graph = graphService.getFullGraph(null, null);
        assertNotNull(graph);
        assertFalse(graph.getNodes().isEmpty());

        DashboardSummaryDto summary = dashboardService.getSummary();
        assertNotNull(summary);
        assertTrue(summary.getActiveFirs() >= 1);
        assertTrue(summary.getLinkedPersons() >= 1);
        assertNotNull(summary.getTrends().get("Active FIRs"));
    }
}
