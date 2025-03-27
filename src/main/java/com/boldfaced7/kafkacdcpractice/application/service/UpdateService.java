package com.boldfaced7.kafkacdcpractice.application.service;

import com.boldfaced7.kafkacdcpractice.application.port.in.UpdateCommand;
import com.boldfaced7.kafkacdcpractice.application.port.in.UpdateUseCase;
import com.boldfaced7.kafkacdcpractice.application.port.out.persistence.FindByIdPort;
import com.boldfaced7.kafkacdcpractice.application.port.out.persistence.UpdatePort;
import com.boldfaced7.kafkacdcpractice.domain.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateService implements UpdateUseCase {

    private final FindByIdPort findByIdPort;
    private final UpdatePort updatePort;

    @Override
    public Model update(UpdateCommand command) {
        var found = findByIdPort.findById(command.id())
                .orElseThrow(() -> new RuntimeException("Can't find id " + command.id()));

        var toBeUpdated = found.update(command.content());
        return updatePort.update(toBeUpdated);
    }
}
