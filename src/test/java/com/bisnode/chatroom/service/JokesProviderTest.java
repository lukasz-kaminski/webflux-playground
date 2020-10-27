package com.bisnode.chatroom.service;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class JokesProviderTest {

    ChuckNorrisClient chuckNorrisClient = mock(ChuckNorrisClient.class);

    JokesProvider jokesProvider = new JokesProvider(chuckNorrisClient);


    @Test
    void should() {
        //given
        when(chuckNorrisClient.nextJoke()).thenReturn(Mono.just("Some joke"));
        //when
        StepVerifier.create(jokesProvider.publisher())
                .assertNext(message -> assertEquals("Some joke", message.getText()))
                .expectNextCount(9)
                .verifyComplete();
        //then
    }

}