package com.kuruhu.court;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/court")
public class CourtController {
    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("CourtController active");
    }

    @PostMapping("/process")
    public ResponseEntity<String> process(@RequestBody Object payload) {
        return ResponseEntity.ok("Processed by CourtController");
    }
}
