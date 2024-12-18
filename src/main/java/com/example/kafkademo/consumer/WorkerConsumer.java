package com.example.kafkademo.consumer;

import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WorkerConsumer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public WorkerConsumer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "input-topic", groupId = "group-process-input-1")
    public void listenAndProcessGroup1(String message) {
        log.info("Group 1 - Processing message: {}", message);
        kafkaTemplate.send("output-topic-group1", "Processed by Group 1: " + message);
    }

    @KafkaListener(topics = "input-topic", groupId = "group-process-input-2")
    public void listenAndProcessGroup2(String message) {
        log.info("Group 2 - Processing message: {}", message);
        kafkaTemplate.send("output-topic-group2", "Processed by Group 2: " + message);
    }
}