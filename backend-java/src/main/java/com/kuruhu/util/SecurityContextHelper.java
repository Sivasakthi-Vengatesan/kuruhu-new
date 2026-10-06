package com.kuruhu.util;

import com.kuruhu.security.SecurityUtils;

public class SecurityContextHelper {
    public static String getCurrentOfficer() {
        return SecurityUtils.getCurrentUsername();
    }
}
