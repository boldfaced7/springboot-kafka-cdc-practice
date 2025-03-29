package com.boldfaced7.kafkacdcpractice.application.port.out.messaging;

import com.boldfaced7.kafkacdcpractice.domain.event.UpdatedEvent;

public interface UpdatedEventPublisherPort {
    void publishUpdatedEvent(UpdatedEvent updatedEvent);
}
