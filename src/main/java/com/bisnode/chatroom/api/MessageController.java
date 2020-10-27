package com.bisnode.chatroom.api;

import com.bisnode.chatroom.Message;
import com.bisnode.chatroom.MessageRepository;
import com.bisnode.chatroom.service.JokesProvider;
import com.bisnode.chatroom.service.MessageFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
class MessageController {

    private final MessageFacade messageFacade;
    private final JokesProvider jokesProvider;

    @PostMapping(path = "/messages", consumes = MediaType.APPLICATION_JSON_VALUE)
    Mono<Message> postMessage(@RequestBody Message message) {
        return messageFacade.save(message);
    }

    @GetMapping(path = "/messages", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Message> getMessagesStream() {
        return messageFacade.listenForMessages();
    }

    @GetMapping(path = "/jokes", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Message> getJokesStream() {
        return jokesProvider.publisher();
    }



}
