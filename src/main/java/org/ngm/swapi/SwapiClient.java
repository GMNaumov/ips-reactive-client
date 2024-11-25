package org.ngm.swapi;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("")
public class SwapiClient {
    private final WebClient webClient = WebClient.create("https://swapi.dev/");

    @GetMapping("/hello")
    public Mono<String> getPerson() {
        return webClient.get()
                .uri("/api/people/1/")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class);
    }
}
