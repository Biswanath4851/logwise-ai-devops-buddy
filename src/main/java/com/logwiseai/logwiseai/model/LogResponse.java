package com.logwiseai.logwiseai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogResponse {
    private String summary;
    private int logsConsidered;
}
