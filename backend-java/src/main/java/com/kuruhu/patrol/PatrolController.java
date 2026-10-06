package com.kuruhu.patrol;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/patrol")
public class PatrolController {
    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("PatrolController active");
    }

    @PostMapping("/process")
    public ResponseEntity<String> process(@RequestBody Object payload) {
        return ResponseEntity.ok("Processed by PatrolController");
    }
}
