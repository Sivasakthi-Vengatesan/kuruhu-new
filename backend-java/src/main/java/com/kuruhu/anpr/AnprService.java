package com.kuruhu.anpr;

import java.util.List;

public interface AnprService {
    Object logCapture(Object param);
    Object checkHotlist(Object param);
    Object searchPlateHistory(Object param);
}
