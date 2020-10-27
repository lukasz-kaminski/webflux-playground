package com.bisnode.chatroom.config;

import com.bisnode.chatroom.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Collation;

import java.util.Locale;

@Configuration
@RequiredArgsConstructor
class MongoCollectionConfig implements InitializingBean {

    private final ReactiveMongoOperations mongoOperations;

    @Override
    public void afterPropertiesSet() {
        mongoOperations.createCollection(
                Message.class,
                CollectionOptions.just(Collation.of(new Locale("pl")))
                        .capped()
                        .maxDocuments(10)
                        .size(1024 * 1024)
        ).subscribe();
    }


}
