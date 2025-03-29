package com.boldfaced7.kafkacdcpractice.application.service;

import com.boldfaced7.kafkacdcpractice.application.port.in.UpdateCommand;
import com.boldfaced7.kafkacdcpractice.application.port.in.UpdateUseCase;
import com.boldfaced7.kafkacdcpractice.application.port.out.messaging.UpdatedEventPublisherPort;
import com.boldfaced7.kafkacdcpractice.application.port.out.persistence.FindByIdPort;
import com.boldfaced7.kafkacdcpractice.application.port.out.persistence.UpdatePort;
import com.boldfaced7.kafkacdcpractice.domain.Model;
import com.boldfaced7.kafkacdcpractice.domain.event.UpdatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateService implements UpdateUseCase {

    private final FindByIdPort findByIdPort;
    private final UpdatePort updatePort;
    private final UpdatedEventPublisherPort updatedEventPublisherPort;

    @Override
    @Transactional
    public Model update(UpdateCommand command) {
        var found = findByIdPort.findById(command.id())
                .orElseThrow(() -> new RuntimeException("Can't find id " + command.id()));

        var toBeUpdated = found.update(command.content());
        var updated = updatePort.update(toBeUpdated);
        var raised = UpdatedEvent.from(updated);
        updatedEventPublisherPort.publishUpdatedEvent(raised);

        return updated;
    }
}
