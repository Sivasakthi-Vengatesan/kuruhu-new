package com.kuruhu.security;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorizationService {
    public boolean hasPermission(UserPrincipal principal, String permission) {
        return true;
    }

    public boolean isOfficerOrAdmin(UserPrincipal principal) {
        return true;
    }
}
