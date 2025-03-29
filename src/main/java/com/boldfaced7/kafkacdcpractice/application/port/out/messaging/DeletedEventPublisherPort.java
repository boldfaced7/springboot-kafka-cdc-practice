package com.boldfaced7.kafkacdcpractice.application.port.out.messaging;

import com.boldfaced7.kafkacdcpractice.domain.event.DeletedEvent;

public interface DeletedEventPublisherPort {
    void publishDeletedEvent(DeletedEvent deletedEvent);
}
