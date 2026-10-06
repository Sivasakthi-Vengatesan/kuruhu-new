package com.kuruhu.util;

public class ValidationUtils {
    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("^\\+?[0-9\\s-]{10,15}$");
    }
}
