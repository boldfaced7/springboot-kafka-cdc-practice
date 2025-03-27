package com.boldfaced7.kafkacdcpractice.application.service;

import com.boldfaced7.kafkacdcpractice.application.port.in.DeleteCommand;
import com.boldfaced7.kafkacdcpractice.application.port.in.DeleteUseCase;
import com.boldfaced7.kafkacdcpractice.application.port.out.persistence.DeleteByIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteService implements DeleteUseCase {

    private final DeleteByIdPort deleteByIdPort;

    @Override
    public void delete(DeleteCommand command) {
        deleteByIdPort.deleteById(command.id());
    }

}
