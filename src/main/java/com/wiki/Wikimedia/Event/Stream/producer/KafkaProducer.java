package com.wiki.Wikimedia.Event.Stream.producer;

import com.wiki.Wikimedia.Event.Stream.config.KafkaConfig;
import com.wiki.Wikimedia.Event.Stream.constant.WikimediaConstant;
import jakarta.websocket.server.ServerEndpoint;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {


    private final KafkaTemplate<String, String > kafkaTemplate;
    private final NewTopic wikimediaStreamTopic;


    public void sendMessage(String message){

        Message<String> kafkaEvent =  MessageBuilder
                .withPayload(message)
                .setHeader(KafkaHeaders.TOPIC, wikimediaStreamTopic.name())
                .build();


        // kafkaTemplate.send(WikimediaConstant.WIKIMEDIA_TOPIC_NAME,message);

        //second way ->
        kafkaTemplate.send(kafkaEvent);

        log.info("Sending message : {}", kafkaEvent);
        log.info("Sending message to topic : {}", message );
    }

    public void sendMessageAsync(String message){
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(WikimediaConstant.WIKIMEDIA_TOPIC_NAME,message);

        future.whenComplete((result, ex)->{
            if (ex == null){
                log.info("Sent message {} with offset {}", message, result.getRecordMetadata().offset());
            }else {
                log.warn("Unable to send message: {} due to : {}",message, ex.getMessage());
            }
        });
    }


}