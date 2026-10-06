package com.kuruhu.workflow;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/workflows")
public class WorkflowController {
    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("WorkflowController active");
    }

    @PostMapping("/process")
    public ResponseEntity<String> process(@RequestBody Object payload) {
        return ResponseEntity.ok("Processed by WorkflowController");
    }
}
