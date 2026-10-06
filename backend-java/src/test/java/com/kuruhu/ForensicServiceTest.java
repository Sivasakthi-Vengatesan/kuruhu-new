package com.kuruhu;

import com.kuruhu.forensics.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ForensicServiceTest {
    @Test
    void testForensicBallistics() {
        ForensicServiceImpl service = new ForensicServiceImpl(null);
        BallisticsAnalysis res = service.matchBallistics("Glock 19", "9mm");
        assertNotNull(res);
        assertEquals(0.94, res.getConfidenceScore());
    }
}
