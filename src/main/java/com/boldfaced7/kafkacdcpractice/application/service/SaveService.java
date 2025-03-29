package com.boldfaced7.kafkacdcpractice.application.service;

import com.boldfaced7.kafkacdcpractice.application.port.in.SaveCommand;
import com.boldfaced7.kafkacdcpractice.application.port.in.SaveUseCase;
import com.boldfaced7.kafkacdcpractice.application.port.out.messaging.CreatedEventPublisherPort;
import com.boldfaced7.kafkacdcpractice.application.port.out.persistence.SavePort;
import com.boldfaced7.kafkacdcpractice.domain.Model;
import com.boldfaced7.kafkacdcpractice.domain.event.CreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SaveService implements SaveUseCase {

    private final SavePort savePort;
    private final CreatedEventPublisherPort createdEventPublisherPort;

    @Override
    @Transactional
    public Model save(SaveCommand command) {
        var created = command.toModel();
        var saved = savePort.save(created);
        var raised = CreatedEvent.from(saved);
        createdEventPublisherPort.publishSavedEvent(raised);

        return saved;
    }
}
