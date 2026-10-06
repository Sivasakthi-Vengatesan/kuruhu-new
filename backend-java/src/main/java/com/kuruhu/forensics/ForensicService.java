package com.kuruhu.forensics;

import java.util.List;

public interface ForensicService {
    Object createReport(Object param);
    Object matchBallistics(Object param);
    Object analyzeDna(Object param);
    Object verifyCustody(Object param);
}
