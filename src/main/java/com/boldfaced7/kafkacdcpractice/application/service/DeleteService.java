package com.boldfaced7.kafkacdcpractice.application.service;

import com.boldfaced7.kafkacdcpractice.application.port.in.DeleteCommand;
import com.boldfaced7.kafkacdcpractice.application.port.in.DeleteUseCase;
import com.boldfaced7.kafkacdcpractice.application.port.out.messaging.DeletedEventPublisherPort;
import com.boldfaced7.kafkacdcpractice.application.port.out.persistence.DeleteByIdPort;
import com.boldfaced7.kafkacdcpractice.domain.event.DeletedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteService implements DeleteUseCase {

    private final DeleteByIdPort deleteByIdPort;
    private final DeletedEventPublisherPort deletedEventPublisherPort;

    @Override
    @Transactional
    public void delete(DeleteCommand command) {
        deleteByIdPort.deleteById(command.id());
        var raised = new DeletedEvent(command.id());
        deletedEventPublisherPort.publishDeletedEvent(raised);
    }

}
