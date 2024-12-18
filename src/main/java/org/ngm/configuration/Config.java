package org.ngm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Config {
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://swapi.dev")
                .build();
    }
}
