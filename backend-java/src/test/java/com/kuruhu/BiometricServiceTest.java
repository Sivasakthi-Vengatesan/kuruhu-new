package com.kuruhu;

import com.kuruhu.biometrics.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BiometricServiceTest {
    @Test
    void testFaceMatch() {
        BiometricServiceImpl service = new BiometricServiceImpl(null);
        FacialMatchResult res = service.matchFace("vec-123");
        assertNotNull(res);
        assertEquals("Ramesh Gowda", res.getFullName());
    }
}
