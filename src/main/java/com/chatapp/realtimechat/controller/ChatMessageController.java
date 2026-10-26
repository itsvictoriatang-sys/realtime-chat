
package com.chatapp.realtimechat.controller;

import com.chatapp.realtimechat.model.ChatMessage;
import com.chatapp.realtimechat.repository.ChatMessageRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatMessageController {

    private final ChatMessageRepository messageRepository;

    public ChatMessageController(
            ChatMessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/api/messages")
    public List<ChatMessage> getMessages() {
        return messageRepository.findAll();
    }
}
