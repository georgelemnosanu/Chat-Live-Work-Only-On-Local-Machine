package com.example.hotelManager.demo.controller;



import com.example.hotelManager.demo.model.ChatMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;

@Component
public class ChatMessageHandler {
    private static final Logger logger = LoggerFactory.getLogger(ChatMessageHandler.class);

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @RabbitListener(queues = "chat_queue")
    public void handleChatMessage(ChatMessage chatMessage) {
        logger.info("Received message: {}", chatMessage.toString());

        messagingTemplate.convertAndSend("/topic/public", chatMessage);
    }
}