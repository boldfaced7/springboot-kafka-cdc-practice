package com.boldfaced7.kafkacdcpractice.adapter.out.messaging.dto;

import com.boldfaced7.kafkacdcpractice.adapter.out.persistence.JpaEntity;

public class MessageMapper {

    public static Message toMessage(JpaEntity jpaEntity, OperationType operationType) {
        return new Message(
                jpaEntity.getId(),
                new Message.Payload(
                        jpaEntity.getUserId(),
                        jpaEntity.getUserAge(),
                        jpaEntity.getUserName(),
                        jpaEntity.getContent(),
                        jpaEntity.getCreatedAt(),
                        jpaEntity.getUpdatedAt()
                ),
                operationType
        );
    }

    public static Message toMessage(Long id) {
        return new Message(id, null, OperationType.DELETE);
    }
}
