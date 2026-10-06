package com.kuruhu;

import com.kuruhu.court.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourtServiceTest {
    @Test
    void testCourtHearing() {
        CourtHearing hearing = new CourtHearing();
        hearing.setCaseNumber("CR-2024-001");
        assertEquals("CR-2024-001", hearing.getCaseNumber());
    }
}
