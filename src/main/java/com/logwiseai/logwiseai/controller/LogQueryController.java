package com.logwiseai.logwiseai.controller;

import com.logwiseai.logwiseai.model.LogQueryRequest;
import com.logwiseai.logwiseai.model.LogResponse;
import com.logwiseai.logwiseai.service.LogWiseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LogQueryController {

    private final LogWiseService logWiseService;

    @PostMapping("/ask")
    public ResponseEntity<LogResponse> queryLogs(LogQueryRequest request) {
        LogResponse response = logWiseService.processQuery(request);
        return ResponseEntity.ok(response);
    }
}
