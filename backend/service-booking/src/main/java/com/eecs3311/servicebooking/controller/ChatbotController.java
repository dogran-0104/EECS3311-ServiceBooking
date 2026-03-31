package com.eecs3311.servicebooking.controller;

import com.eecs3311.servicebooking.service.ChatbotService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/chatbot")
public class ChatbotController {

    private final ChatbotService chatbotService;

    public ChatbotController(ChatbotService chatbotService) {
        this.chatbotService = chatbotService;
    }

    @PostMapping("/ask")
    public Map<String, String> ask(@RequestBody Map<String, String> body) {
        String question = body.get("question");
        String answer = chatbotService.answer(question);
        return Map.of("answer", answer);
    }
}
