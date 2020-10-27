package com.bisnode.chatroom.api;

import com.bisnode.chatroom.service.ChuckNorrisClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ChuckNorrisClientConfig {

    @Bean
    ChuckNorrisClient chuckNorrisClient() {
        return new ChuckNorrisClient();
    }

}
