package example.api.openAi.controller;

import example.api.openAi.controller.dto.ChatRequest;
import example.api.openAi.controller.dto.ChatResponse;
import example.api.openAi.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    @PostMapping
    public ResponseEntity<ChatResponse> chat(@RequestBody ChatRequest chatRequest) {
        String answer = chatService.getAnswer(chatRequest.getMessage());

        return ResponseEntity.ok(ChatResponse.of(answer));
    }
}
