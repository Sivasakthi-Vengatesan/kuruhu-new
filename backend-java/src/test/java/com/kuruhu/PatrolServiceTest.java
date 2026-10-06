package com.kuruhu;

import com.kuruhu.patrol.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatrolServiceTest {
    @Test
    void testPatrolBeat() {
        PatrolBeat beat = new PatrolBeat();
        beat.setBeatCode("BEAT-04");
        assertEquals("BEAT-04", beat.getBeatCode());
    }
}
