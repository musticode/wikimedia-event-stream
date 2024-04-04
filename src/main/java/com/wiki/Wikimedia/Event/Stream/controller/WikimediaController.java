package com.wiki.Wikimedia.Event.Stream.controller;

import com.wiki.Wikimedia.Event.Stream.stream.WikimediaStreamConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/wikimedia")
@RequiredArgsConstructor
public class WikimediaController {


    // https://youtu.be/uFCcr2hdN_E?list=PL41m5U3u3wwk7AOA7wSbrwUvMK_uUQ46u&t=1065

    private final WikimediaStreamConsumer streamConsumer;

    @GetMapping
    public void startPublishing() {
        streamConsumer.consumeStreamAndPublish();
    }

}
