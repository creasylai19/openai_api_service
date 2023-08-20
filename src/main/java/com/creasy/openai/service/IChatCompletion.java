package com.creasy.openai.service;

import com.theokanning.openai.completion.chat.ChatMessage;

import java.util.List;

public interface IChatCompletion {
    List<ChatMessage> chat(List<ChatMessage> messages);
}
