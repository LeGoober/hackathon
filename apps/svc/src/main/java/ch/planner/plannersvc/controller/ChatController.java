package ch.planner.plannersvc.controller;
import java.util.Map;

import ch.planner.plannersvc.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService){
        this.chatService = chatService;
    }
//localhost:/8080/ai/generate
    @GetMapping("/ai/generate")
    public Map<String, String>generate(@RequestParam(value = "message",
    defaultValue = "What's your name?") String message){
        String response = chatService.generateResponse(message);
        return Map.of("Generation ", response);
    }
}
