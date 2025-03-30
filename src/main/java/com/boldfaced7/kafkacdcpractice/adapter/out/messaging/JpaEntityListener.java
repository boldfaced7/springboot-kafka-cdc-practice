package com.boldfaced7.kafkacdcpractice.adapter.out.messaging;

import com.boldfaced7.kafkacdcpractice.adapter.out.messaging.dto.MessageMapper;
import com.boldfaced7.kafkacdcpractice.adapter.out.messaging.dto.OperationType;
import com.boldfaced7.kafkacdcpractice.adapter.out.persistence.JpaEntity;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JpaEntityListener {

    @Lazy
    private final KafkaProducer kafkaProducer;

    @PostPersist
    public void handleCreate(JpaEntity entity) {
        var received = MessageMapper.toMessage(entity, OperationType.CREATE);
        kafkaProducer.sendMessage(received);
    }

    @PostUpdate
    public void handleUpdate(JpaEntity entity) {
        var received = MessageMapper.toMessage(entity, OperationType.UPDATE);
        kafkaProducer.sendMessage(received);
    }

    @PostRemove
    public void handleDelete(JpaEntity entity) {
        var received = MessageMapper.toMessage(entity.getId());
        kafkaProducer.sendMessage(received);
    }
}
