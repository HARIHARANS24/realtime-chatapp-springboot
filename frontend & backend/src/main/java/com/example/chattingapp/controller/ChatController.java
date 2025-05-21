package com.example.chattingapp.controller;

import com.example.chattingapp.model.Message;
import com.example.chattingapp.model.Notification;
import com.example.chattingapp.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final MessageService messageService;

    @MessageMapping("/chat")
    public void process(@Payload Message message) {
        Message savedMessage = messageService.save(message);
        messagingTemplate.convertAndSendToUser(
                message.getReceiverId(),
                "/queue/messages",
                new Notification(
                        savedMessage.getId(),
                        savedMessage.getSenderId(),
                        savedMessage.getReceiverId(),
                        savedMessage.getContent()
                )
        );
    }

    @GetMapping("/messages/{senderId}/{receiverId}")
    public ResponseEntity<List<Message>> getChatMessages(
            @PathVariable String senderId,
            @PathVariable String receiverId
    ) {
        var chatMessages = messageService.getChatMessage(senderId, receiverId);
        return ResponseEntity.ok(chatMessages);
    }

}
