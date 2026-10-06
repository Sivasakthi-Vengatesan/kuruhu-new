package com.kuruhu.surveillance;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/surveillance")
public class SurveillanceController {
    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("SurveillanceController active");
    }

    @PostMapping("/process")
    public ResponseEntity<String> process(@RequestBody Object payload) {
        return ResponseEntity.ok("Processed by SurveillanceController");
    }
}
