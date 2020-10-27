package com.bisnode.chatroom.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ChuckNorrisClient {

    private final WebClient webClient = WebClient.create("https://api.chucknorris.io/jokes/random");

    Mono<String> nextJoke() {
        return webClient.get().retrieve().bodyToMono(Joke.class).map(Joke::getValue);
    }

}
