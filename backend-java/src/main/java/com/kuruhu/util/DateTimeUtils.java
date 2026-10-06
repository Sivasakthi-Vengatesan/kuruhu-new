package com.kuruhu.util;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
    public static String formatIso(OffsetDateTime dt) {
        return dt != null ? dt.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME) : "";
    }
}
