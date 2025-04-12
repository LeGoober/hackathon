package ch.planner.plannersvc.controller;
import java.util.Map;

import ch.planner.plannersvc.service.ChatService;

@RestController
public class ChatController {
    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService){
        this.chatService = chatService;
    }

    @GetMapping("/ai/generate")
    public Map<String, String>generate(@RequestParam(value = "message",
    defaultValue = "What's your name?"String message)){
        String response = chatService.generateResponse(message);
        return Map.of("Generation ", response);
    }
}
