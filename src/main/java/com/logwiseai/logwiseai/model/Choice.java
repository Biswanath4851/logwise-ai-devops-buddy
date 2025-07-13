package com.logwiseai.logwiseai.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Choice {
    private int index;
    private Message message;

    @JsonProperty("finish_reason")
    private String finishReason;

    // getters and setters
}
