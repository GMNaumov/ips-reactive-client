package org.ngm.swapi;

import org.ngm.model.SwapiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("")
public class SwapiService {
    private final WebClient webClient;

    @Autowired
    public SwapiService(WebClient client) {
        this.webClient = client;
    }


    @GetMapping("/getall")
    public Flux<SwapiResponse> getAllPeople() {
        return webClient.get()
                .uri("/api/people/")
                .retrieve()
                .bodyToFlux(SwapiResponse.class);
    }

    @GetMapping("/getbyid/{id}")
    public Mono<SwapiResponse> getPersonById(@PathVariable int id) {
        return webClient.get()
                .uri("/api/people/" + id)
                .retrieve()
                .bodyToMono(SwapiResponse.class);
    }
}
