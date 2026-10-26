package com.chatapp.realtimechat.repository;

import com.chatapp.realtimechat.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepository
        extends JpaRepository<ChatMessage, Long> {
}