package com.logwiseai.logwiseai.service;

import com.logwiseai.logwiseai.model.LogQueryRequest;
import com.logwiseai.logwiseai.model.LogResponse;
import org.springframework.stereotype.Service;

@Service
public class LogWiseService {
    public LogResponse processQuery(LogQueryRequest request) {
        return new LogResponse("Dummy Summary : all system stable",20);
    }
}
