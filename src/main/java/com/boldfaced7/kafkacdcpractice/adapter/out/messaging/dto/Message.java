package com.boldfaced7.kafkacdcpractice.adapter.out.messaging.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private Long id;
    private Payload payload;
    private OperationType operationType;

    public record Payload(
            Long userId,
            Integer userAge,
            String userName,
            String content,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {}
}
