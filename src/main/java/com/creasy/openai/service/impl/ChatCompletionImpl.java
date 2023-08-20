package com.creasy.openai.service.impl;

import com.creasy.openai.common.ModelEnum;
import com.creasy.openai.service.IChatCompletion;
import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionResult;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatCompletionImpl implements IChatCompletion {

    @Override
    public List<ChatMessage> chat(List<ChatMessage> messages) {
        String token = System.getenv("OPENAI_TOKEN");
        OpenAiService service = new OpenAiService(token, Duration.ofSeconds(30));
        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest
                .builder()
                .model(ModelEnum.GPT_3_5_TURBO.getCode())
                .messages(messages).build();
        ChatCompletionResult chatCompletion = service.createChatCompletion(chatCompletionRequest);
        return chatCompletion.getChoices().stream().map(ChatCompletionChoice::getMessage).collect(Collectors.toList());
    }
}
