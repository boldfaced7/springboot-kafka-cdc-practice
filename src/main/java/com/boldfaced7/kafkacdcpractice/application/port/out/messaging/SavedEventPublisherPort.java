package com.boldfaced7.kafkacdcpractice.application.port.out.messaging;

import com.boldfaced7.kafkacdcpractice.domain.event.SavedEvent;

public interface SavedEventPublisherPort {
    void publishSavedEvent(SavedEvent savedEvent);
}
