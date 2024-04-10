package com.wiki.Wikimedia.Event.Stream.stream;

import com.wiki.Wikimedia.Event.Stream.constant.WikimediaConstant;
import com.wiki.Wikimedia.Event.Stream.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class WikimediaStreamConsumer {

    private final WebClient webClient;
    private final KafkaProducer producer;



    public WikimediaStreamConsumer(WebClient.Builder webClientBuilder, KafkaProducer producer) {
        this.webClient = webClientBuilder
                .baseUrl(WikimediaConstant.MAIN_URL)
                .build();
        this.producer = producer;
    }

    public void consumeStreamAndPublish(){
        log.info("Streaming started");

        webClient.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(producer::sendMessage);
    }




}
