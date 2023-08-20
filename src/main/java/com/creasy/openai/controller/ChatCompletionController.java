package com.creasy.openai.controller;

import com.creasy.openai.common.ModelEnum;
import com.creasy.openai.dto.ResponseDto;
import com.creasy.openai.dto.ResponseUtil;
import com.creasy.openai.service.IChatCompletion;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/chatCompletion")
@RestController
public class ChatCompletionController {

    @Autowired
    IChatCompletion iChatCompletion;

    @RequestMapping("chat")
    public ResponseDto chat(@RequestBody ArrayList<ChatMessage> messages){
        List<ChatMessage> retMegs = iChatCompletion.chat(messages);
        return ResponseUtil.buildSuccess(retMegs);
    }

}
