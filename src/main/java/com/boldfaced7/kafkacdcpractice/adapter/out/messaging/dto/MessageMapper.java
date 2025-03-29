package com.boldfaced7.kafkacdcpractice.adapter.out.messaging.dto;

import com.boldfaced7.kafkacdcpractice.domain.event.DeletedEvent;
import com.boldfaced7.kafkacdcpractice.domain.event.SavedEvent;
import com.boldfaced7.kafkacdcpractice.domain.event.UpdatedEvent;

public class MessageMapper {

    public static Message toMessage(DeletedEvent deletedEvent) {
        return new Message(
                deletedEvent.id().value(),
                null,
                OperationType.DELETE
        );
    }

    public static Message toMessage(SavedEvent savedEvent) {
        return new Message(
                savedEvent.id().value(),
                new Message.Payload(
                        savedEvent.userId().value(),
                        savedEvent.userAge().value(),
                        savedEvent.userName().value(),
                        savedEvent.content().value(),
                        savedEvent.createdAt(),
                        savedEvent.updatedAt()
                ),
                OperationType.CREATE
        );
    }

    public static Message toMessage(UpdatedEvent updatedEvent) {
        return new Message(
                updatedEvent.id().value(),
                new Message.Payload(
                        updatedEvent.userId().value(),
                        updatedEvent.userAge().value(),
                        updatedEvent.userName().value(),
                        updatedEvent.content().value(),
                        updatedEvent.createdAt(),
                        updatedEvent.updatedAt()
                ),
                OperationType.UPDATE
        );

    }
}
