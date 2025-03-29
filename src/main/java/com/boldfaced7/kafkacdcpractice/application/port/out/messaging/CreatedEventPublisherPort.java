package com.boldfaced7.kafkacdcpractice.application.port.out.messaging;

import com.boldfaced7.kafkacdcpractice.domain.event.CreatedEvent;

public interface CreatedEventPublisherPort {
    void publishSavedEvent(CreatedEvent createdEvent);
}
