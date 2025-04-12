package ch.planner.plannersvc.service;

@Service
public class ChatService {
    private final OllamaChatModel chatModel;

    @Autowired
    public ChatService(OllamaChatModel chatModel){
        this.chatModel = chatModel;
    }

    public String generateResponse(String message){
        return chatModel.call(message);
    }
}
