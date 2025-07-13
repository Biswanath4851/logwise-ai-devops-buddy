package com.logwiseai.logwiseai.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Message {
    private String role;
    private String content;

    // getters and setters
}
