package com.wiki.Wikimedia.Event.Stream.config;

import com.wiki.Wikimedia.Event.Stream.constant.WikimediaConstant;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic wikimediaStreamTopic(){
        return TopicBuilder
                .name(WikimediaConstant.WIKIMEDIA_TOPIC_NAME)
                .build();
    }


}
