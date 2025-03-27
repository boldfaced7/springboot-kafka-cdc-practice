package com.boldfaced7.kafkacdcpractice.application.service;

import com.boldfaced7.kafkacdcpractice.application.port.in.GetByIdCommand;
import com.boldfaced7.kafkacdcpractice.application.port.in.GetByIdQuery;
import com.boldfaced7.kafkacdcpractice.application.port.out.persistence.FindByIdPort;
import com.boldfaced7.kafkacdcpractice.domain.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetByIdService implements GetByIdQuery {

    private final FindByIdPort findByIdPort;

    @Override
    public Model getById(GetByIdCommand command) {
        return findByIdPort.findById(command.id())
                .orElseThrow(() -> new RuntimeException("Can't find id " + command.id()));
    }
}
