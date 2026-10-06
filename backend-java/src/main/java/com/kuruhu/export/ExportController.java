package com.kuruhu.export;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/export")
public class ExportController {
    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("ExportController active");
    }

    @PostMapping("/process")
    public ResponseEntity<String> process(@RequestBody Object payload) {
        return ResponseEntity.ok("Processed by ExportController");
    }
}
