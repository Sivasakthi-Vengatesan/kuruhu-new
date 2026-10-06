package com.kuruhu.util;

public class StringFormatUtils {
    public static String maskSensitive(String value) {
        if (value == null || value.length() < 4) return "****";
        return value.substring(0, 2) + "****" + value.substring(value.length() - 2);
    }
}
