package com.github.tantalor93.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class MessageController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(final KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping(
            value = "/ping"
    )
    public ResponseEntity<String> ping() throws ExecutionException, InterruptedException {

        long now = System.currentTimeMillis();

        final ListenableFuture<SendResult<String, String>> test = kafkaTemplate.send(
                "test",
                "message-app-" + now,
                "ping" + now
        );

        SendResult<String, String> stringStringSendResult = test.get();

        return ResponseEntity.ok(stringStringSendResult.toString());
    }
}
