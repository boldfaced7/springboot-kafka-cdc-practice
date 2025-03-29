package com.boldfaced7.kafkacdcpractice.adapter.out.messaging;

import com.boldfaced7.kafkacdcpractice.adapter.out.messaging.dto.MessageMapper;
import com.boldfaced7.kafkacdcpractice.application.port.out.messaging.DeletedEventPublisherPort;
import com.boldfaced7.kafkacdcpractice.application.port.out.messaging.SavedEventPublisherPort;
import com.boldfaced7.kafkacdcpractice.application.port.out.messaging.UpdatedEventPublisherPort;
import com.boldfaced7.kafkacdcpractice.domain.event.DeletedEvent;
import com.boldfaced7.kafkacdcpractice.domain.event.SavedEvent;
import com.boldfaced7.kafkacdcpractice.domain.event.UpdatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaEventPublishAdapter implements
        DeletedEventPublisherPort,
        SavedEventPublisherPort,
        UpdatedEventPublisherPort {

    private final KafkaProducer kafkaProducer;

    @Override
    public void publishDeletedEvent(DeletedEvent deletedEvent) {
        var message = MessageMapper.toMessage(deletedEvent);
        kafkaProducer.sendMessage(message);
    }

    @Override
    public void publishSavedEvent(SavedEvent savedEvent) {
        var message = MessageMapper.toMessage(savedEvent);
        kafkaProducer.sendMessage(message);
    }

    @Override
    public void publishUpdatedEvent(UpdatedEvent updatedEvent) {
        var message = MessageMapper.toMessage(updatedEvent);
        kafkaProducer.sendMessage(message);
    }
}
