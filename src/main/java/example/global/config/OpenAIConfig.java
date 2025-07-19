package example.global.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OpenAIConfig {

    @Value("${openai.api-key}")
    private String apiKey;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .additionalInterceptors(((request, body, execution) -> {
                    request.getHeaders().add("Authorization", "Bearer " + apiKey);
                    request.getHeaders().add("Content-Type", "application/json");
                    return execution.execute(request, body);
                }))
                .build();
    }
}
