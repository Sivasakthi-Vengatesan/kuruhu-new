package com.kuruhu.court;

import java.util.List;

public interface CourtService {
    Object scheduleHearing(Object param);
    Object fileChargeSheet(Object param);
    Object issueWarrant(Object param);
}
