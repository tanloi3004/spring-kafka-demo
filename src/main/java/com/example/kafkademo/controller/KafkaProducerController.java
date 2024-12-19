package com.example.kafkademo.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
@RequiredArgsConstructor
public class KafkaProducerController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @ApiOperation(value = "Publish a message to a Kafka topic", notes = "Provide a topic and a message to publish to the Kafka topic")
    @PostMapping("/publish")
    public String sendMessage(
            @ApiParam(value = "The topic to publish to", example = "input-topic") @RequestParam(value = "topic", defaultValue = "input-topic") String topic,
            @ApiParam(value = "The message to publish", example = "{\"key\":\"value\"}") @RequestBody String message) {
        kafkaTemplate.send(topic, message);
        return "Message published to topic: " + topic;
    }
}