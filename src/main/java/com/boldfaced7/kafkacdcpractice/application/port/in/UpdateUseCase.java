package com.boldfaced7.kafkacdcpractice.application.port.in;

import com.boldfaced7.kafkacdcpractice.domain.Model;

public interface UpdateUseCase {
    Model update(UpdateCommand command);
}
