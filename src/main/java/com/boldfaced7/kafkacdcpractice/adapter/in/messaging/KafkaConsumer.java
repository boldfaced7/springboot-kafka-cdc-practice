package com.boldfaced7.kafkacdcpractice.adapter.in.messaging;

import com.boldfaced7.kafkacdcpractice.common.CustomObjectMapper;
import com.boldfaced7.kafkacdcpractice.adapter.out.messaging.dto.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {

    private final ObjectMapper objectMapper = new CustomObjectMapper();

    @KafkaListener(
            topics = {"my-cdc-topic"},
            groupId = "cdc-consumer-group",
            concurrency = "1"
    )
    public void listen(ConsumerRecord<String, String> record, Acknowledgment acknowledgment) {
        var read = readMessage(record.value());

        log.info("[Consumer] Message arrived! {}, {}, {}",
                read.getOperationType(),
                read.getId(),
                read.getPayload()
        );
        acknowledgment.acknowledge();
    }

    private Message readMessage(String value) {
        try {
            return objectMapper.readValue(value, Message.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error processing json message", e);
        }
    }
}
