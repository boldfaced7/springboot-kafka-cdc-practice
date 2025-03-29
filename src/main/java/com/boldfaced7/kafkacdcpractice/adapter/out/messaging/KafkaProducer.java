package com.boldfaced7.kafkacdcpractice.adapter.out.messaging;

import com.boldfaced7.kafkacdcpractice.adapter.out.messaging.dto.Message;
import com.boldfaced7.kafkacdcpractice.common.CustomObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper = new CustomObjectMapper();

    public void sendMessage(Message message) {
        try {
            kafkaTemplate.send(
                    "my-cdc-topic",
                    message.getId().toString(),
                    objectMapper.writeValueAsString(message)
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error processing json message", e);
        }
    }
}
