package com.wiki.Wikimedia.Event.Stream.service;

import com.wiki.Wikimedia.Event.Stream.constant.WikimediaConstant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.wiki.Wikimedia.Event.Stream.constant.WikimediaConstant.WIKIMEDIA_TOPIC_NAME;

@Service
@Slf4j
@RequiredArgsConstructor
public class StreamService {

    @KafkaListener(topics = "wikimedia_stream_topic", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String event){
        log.info("Event : {}", event);
    }


}
