package com.pramaan;

import com.pramaan.dto.*;
import com.pramaan.service.*;
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
class PramaanComprehensiveIntegrationTest {

    @Autowired
    private AuthService authService;

    @Autowired
    private FirService firService;

    @Autowired
    private PersonService personService;

    @Autowired
    private SearchService searchService;

    @Autowired
    private InvestigatorService investigatorService;

    @Autowired
    private ChatService chatService;

    @Autowired
    private DashboardService dashboardService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private NotificationService notificationService;

    @Test
    void testEndToEndInvestigationWorkflow() {
        // 1. Create FIR
        CreateFirRequest firReq = CreateFirRequest.builder()
                .crimeNumber("FIR/CR/2026/9999")
                .title("Robbery near Commercial Street Jewelry Store")
                .summary("Masked individuals broke into a retail storefront after midnight stealing gold ornaments.")
                .station("Commercial Street PS")
                .district("Bengaluru City")
                .officer("Inspector Ramesh Nayak")
                .priority("high")
                .sections(List.of("BNS 309", "BNS 310"))
                .complainantName("Suresh Kumar")
                .complainantPhone("+91 9845012345")
                .complainantAddress("12th Cross, Commercial Street, Bengaluru")
                .build();

        FirDto createdFir = firService.createFir(firReq);
        assertNotNull(createdFir);
        assertEquals("FIR/CR/2026/9999", createdFir.getNumber());

        // 2. Create Suspect Person
        CreatePersonRequest personReq = CreatePersonRequest.builder()
                .name("Karthik @ Bullet Karthik")
                .aliases(List.of("Bullet", "BK"))
                .age(31)
                .gender("M")
                .role("suspect")
                .risk("high")
                .phone("+91 9988776655")
                .address("Shivajinagar, Bengaluru")
                .build();

        PersonDto createdPerson = personService.createPerson(personReq);
        assertNotNull(createdPerson);
        assertEquals("Karthik @ Bullet Karthik", createdPerson.getName());

        // 3. Search database
        SearchResponse searchRes = searchService.search("Commercial Street");
        assertNotNull(searchRes);
        assertNotNull(searchRes.getItems());

        // 4. AI Investigator Query
        AiQueryRequest queryReq = AiQueryRequest.builder()
                .question("Which FIRs are related to jewelry or Commercial Street?")
                .build();

        AiQueryResponse queryRes = investigatorService.queryInvestigator(queryReq);
        assertNotNull(queryRes);
        assertNotNull(queryRes.getAnswer());
        assertFalse(queryRes.getCitations().isEmpty());

        // 5. Chat Assistant Interaction
        ChatRequest chatReq = ChatRequest.builder()
                .messages(List.of(ChatMessageDto.builder().role("user").content("Summarize recent high priority cases").build()))
                .build();

        ChatResponse chatRes = chatService.processChat(chatReq);
        assertNotNull(chatRes);
        assertNotNull(chatRes.getReply());

        // 6. Dashboard Metrics
        DashboardSummaryDto summary = dashboardService.getSummary();
        assertNotNull(summary);
        assertTrue(summary.getTotalFirs() >= 1);

        // 7. Audit Activity Trail
        List<ActivityEventDto> activities = activityService.getActivities("all", "all");
        assertNotNull(activities);
        assertFalse(activities.isEmpty());

        // 8. Notifications
        List<NotificationDto> notifications = notificationService.getNotifications(null);
        assertNotNull(notifications);
    }
}
