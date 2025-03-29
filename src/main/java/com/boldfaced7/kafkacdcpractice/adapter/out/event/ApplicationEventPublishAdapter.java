package com.boldfaced7.kafkacdcpractice.adapter.out.event;

import com.boldfaced7.kafkacdcpractice.application.port.out.messaging.DeletedEventPublisherPort;
import com.boldfaced7.kafkacdcpractice.application.port.out.messaging.CreatedEventPublisherPort;
import com.boldfaced7.kafkacdcpractice.application.port.out.messaging.UpdatedEventPublisherPort;
import com.boldfaced7.kafkacdcpractice.domain.event.DeletedEvent;
import com.boldfaced7.kafkacdcpractice.domain.event.CreatedEvent;
import com.boldfaced7.kafkacdcpractice.domain.event.UpdatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplicationEventPublishAdapter implements
        DeletedEventPublisherPort,
        CreatedEventPublisherPort,
        UpdatedEventPublisherPort {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publishDeletedEvent(DeletedEvent event) {
        var applicationEvent = new DeletedApplicationEvent(
                this,
                event.id().value(),
                event
        );
        applicationEventPublisher.publishEvent(applicationEvent);
    }

    @Override
    public void publishSavedEvent(CreatedEvent event) {
        var applicationEvent = new CreatedApplicationEvent(
                this,
                event.id().value(),
                event
        );
        applicationEventPublisher.publishEvent(applicationEvent);
    }

    @Override
    public void publishUpdatedEvent(UpdatedEvent event) {
        var applicationEvent = new UpdatedApplicationEvent(
                this,
                event.id().value(),
                event
        );
        applicationEventPublisher.publishEvent(applicationEvent);
    }
}
