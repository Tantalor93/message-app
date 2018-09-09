package com.github.tantalor93;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.UUID;

@SpringBootApplication
@EnableScheduling
public class Application {

    private KafkaTemplate<String, String> kafkaTemplate;

    public Application(final KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Scheduled(fixedDelay = 2000)
    public void sendMessage() {
        kafkaTemplate.send(
                "test",
                "message-app-" + System.currentTimeMillis(),
                UUID.randomUUID().toString().replace("-", "")
        );
    }
}