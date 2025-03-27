package com.boldfaced7.kafkacdcpractice.application.service;

import com.boldfaced7.kafkacdcpractice.application.port.in.SaveCommand;
import com.boldfaced7.kafkacdcpractice.application.port.in.SaveUseCase;
import com.boldfaced7.kafkacdcpractice.application.port.out.persistence.SavePort;
import com.boldfaced7.kafkacdcpractice.domain.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveService implements SaveUseCase {

    private final SavePort savePort;

    @Override
    public Model save(SaveCommand command) {
        var toBeSaved = command.toModel();
        return savePort.save(toBeSaved);
    }
}
