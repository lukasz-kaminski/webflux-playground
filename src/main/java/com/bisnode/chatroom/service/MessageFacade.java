package com.bisnode.chatroom.service;

import com.bisnode.chatroom.Message;
import com.bisnode.chatroom.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MessageFacade {
    private final MessageRepository messageRepository;

    public Flux<Message> listenForMessages() {
        return messageRepository.getMessagesBy();
    }

    public Mono<Message> save(Message message) {
        return messageRepository.save(message);
    }
}
