package com.kuruhu;

import com.kuruhu.analytics.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AnalyticsServiceTest {
    @Test
    void testRecidivism() {
        PredictiveAnalyticsService service = new PredictiveAnalyticsService();
        Double rate = service.calculateRecidivismProbability("P-101");
        assertEquals(0.18, rate);
    }
}
