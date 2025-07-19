package example.global.client.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OpenAiRequest {

    // 사용할 모델명
    private String model;

    // 메세지 리스트
    private List<OpenAiMessage> messages;

    public OpenAiRequest(String model, List<OpenAiMessage> messages) {
        this.model = model;
        this.messages = messages;
    }
}
