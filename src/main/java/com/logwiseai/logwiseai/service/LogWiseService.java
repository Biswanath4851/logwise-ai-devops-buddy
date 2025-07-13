package com.logwiseai.logwiseai.service;

import com.logwiseai.logwiseai.model.LogSummaryResponse;
import com.logwiseai.logwiseai.model.LogQueryRequest;
import com.logwiseai.logwiseai.model.LogResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class LogWiseService {

    private final WebClient openAiWebClient;

    @Value("${openai.model}")
    private String openAiModel;

    public LogSummaryResponse processQuery(LogQueryRequest request) {
        String prompt = buildPrompt(request);

        LogResponse logResponse = openAiWebClient
                .post().bodyValue(createRequestBody(prompt))
                .retrieve()
                .bodyToMono(LogResponse.class)
                .block();

        if (logResponse == null || logResponse.getChoices().isEmpty()) {
            throw new RuntimeException("No response or choices from OpenAI.");
        }

        var choice = logResponse.getChoices().get(0);
        var usage = logResponse.getUsage();

        return new LogSummaryResponse(
                choice.getMessage().getContent(),
                choice.getFinishReason(),
                usage.getPromptTokens(),
                usage.getCompletionTokens(),
                usage.getTotalTokens()
        );
    }

    private Map<String, Object> createRequestBody(String prompt) {
        Map<String, Object> body = new HashMap<>();
        body.put("model", openAiModel);

        List<Map<String, String>> messages = new ArrayList<>();
        messages.add(Map.of("role", "user", "content", prompt));
        body.put("messages", messages);

        return body;
    }

    private String buildPrompt(LogQueryRequest request) {
        return "You are an expert in analyzing logs. " +
                "Given the following question: " + request.getQuestion() + "\n" +
                "From: " + request.getFromTimeStamp() + "\n" +
                "To: " + request.getToTimeStamp() + "\n" +
                "Service: " + request.getServiceName() + "\n" +
                "Please provide a concise summary of the logs and any relevant insights.";
    }
}
