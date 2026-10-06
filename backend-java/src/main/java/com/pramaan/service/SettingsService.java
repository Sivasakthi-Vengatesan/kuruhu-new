package com.pramaan.service;

import com.pramaan.dto.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SettingsService {

    public Map<String, Object> getSettings() {
        List<String> districts = List.of(
                "Bagalkote", "Ballari", "Belagavi City", "Bengaluru City", "Bengaluru Rural", "Bidar", "Chamarajanagara", "Chikkaballapura",
                "Chikkamagaluru", "Chitradurga", "Dakshina Kannada", "Davanagere", "Dharwad", "Gadag", "Hassan", "Haveri", "Hubballi-Dharwad City",
                "Kalaburagi", "Kodagu", "Kolar", "Koppal", "Mandya", "Mangaluru City", "Mysuru City", "Mysuru District", "Raichur", "Ramanagara",
                "Shivamogga", "Tumakuru", "Udupi", "Uttara Kannada", "Vijayapura", "Yadgiri"
        );

        List<Map<String, String>> languages = List.of(
                Map.of("code", "kn", "label", "ಕನ್ನಡ — Kannada"),
                Map.of("code", "en", "label", "English"),
                Map.of("code", "hi", "label", "हिन्दी — Hindi"),
                Map.of("code", "ur", "label", "اردو — Urdu")
        );

        return Map.of(
                "systemName", "PRAMAAN — Evidence • Intelligence • Justice",
                "version", "1.0.0",
                "state", "Karnataka State Police",
                "districts", districts,
                "languages", languages
        );
    }
}