package com.kuruhu;

import com.kuruhu.anpr.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AnprServiceTest {
    @Test
    void testAnprCapture() {
        AnprCapture capture = new AnprCapture();
        capture.setPlateNumber("KA-01-MJ-5021");
        assertEquals("KA-01-MJ-5021", capture.getPlateNumber());
    }
}
