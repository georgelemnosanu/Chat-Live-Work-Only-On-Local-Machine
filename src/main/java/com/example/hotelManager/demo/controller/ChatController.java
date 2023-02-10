package com.example.hotelManager.demo.controller;


import com.example.hotelManager.demo.model.ChatMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ChatController {
    private final RabbitTemplate rabbitTemplate;
    @Autowired
    private ChatMessageHandler chatMessageHandler;
    private final SimpMessageSendingOperations messagingTemplate;


    public ChatController(RabbitTemplate rabbitTemplate, SimpMessageSendingOperations messagingTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        this.messagingTemplate = messagingTemplate;
    }


    @MessageMapping("/chat.sendMessage")
    @PostMapping("/chat.sendMessage")
    public void sendMessage(@RequestBody ChatMessage chatMessage) {
        chatMessage.setType(ChatMessage.MessageType.CHAT);
       chatMessageHandler.handleChatMessage(chatMessage);
    }


    @SubscribeMapping("/topic/public")
    public void handleChatMessage(ChatMessage chatMessage) {
        messagingTemplate.convertAndSend("/topic/public", chatMessage);
    }


}