
package com.chatapp.realtimechat.handler;

import com.chatapp.realtimechat.model.ChatMessage;
import com.chatapp.realtimechat.repository.ChatMessageRepository;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ChatWebSocketHandler extends TextWebSocketHandler {

    private final Set<WebSocketSession> sessions =
            ConcurrentHashMap.newKeySet();

    private final ChatMessageRepository messageRepository;

    public ChatWebSocketHandler(
            ChatMessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessions.add(session);
    }

    @Override
    protected void handleTextMessage(
            WebSocketSession session,
            TextMessage message) throws Exception {

        String content = message.getPayload();

        if (content == null || content.isBlank()) {
            return;
        }

        ChatMessage chatMessage = new ChatMessage(content);

        messageRepository.save(chatMessage);

        for (WebSocketSession client : sessions) {
            if (client.isOpen()) {
                synchronized (client) {
                    client.sendMessage(new TextMessage(content));
                }
            }
        }
    }

    @Override
    public void afterConnectionClosed(
            WebSocketSession session,
            org.springframework.web.socket.CloseStatus status) {
        sessions.remove(session);
    }
}
