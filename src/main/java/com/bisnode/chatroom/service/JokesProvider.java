package com.bisnode.chatroom.service;

import com.bisnode.chatroom.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class JokesProvider {

    private final ChuckNorrisClient client;

    public Flux<Message> publisher() {
        return Flux.interval(Duration.ofSeconds(10L))
                .take(10)
                .flatMap(this::fetchJoke);
    }

    Mono<Message> fetchJoke(long jokeNumber) {
        return client.nextJoke()
                .map(value -> new Message(Long.toString(jokeNumber), value));
    }

}
