/* (C)2026 */
package com.self.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(path = "/sse")
public class SseController {
    @GetMapping(path = "/song-list", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getSongListSseFlux() {
        return Flux.interval(Duration.ofSeconds(5))
                .map(
                        sequence ->
                                "Flux value " + sequence + " at " + LocalDateTime.now().toString());
    }

    @GetMapping(path = "/song-list-event")
    public Flux<ServerSentEvent<String>> getSongListSseEventFlux() {
        return Flux.interval(Duration.ofSeconds(5))
                .map(
                        sequence ->
                                ServerSentEvent.<String>builder()
                                        .id(String.valueOf(sequence))
                                        .data(
                                                "Flux value "
                                                        + sequence
                                                        + " at "
                                                        + LocalDateTime.now().toString())
                                        .build());
    }
}
