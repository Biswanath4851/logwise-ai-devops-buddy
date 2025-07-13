package com.logwiseai.logwiseai.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LogSummaryResponse {
    private String summary;
    private String finishReason;
    private int promptTokens;
    private int completionTokens;
    private int totalTokens;
}
