package com.logwiseai.logwiseai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogQueryRequest {
    private String question;
    private String fromTimeStamp;
    private String toTimeStamp;
    private String serviceName;
}
