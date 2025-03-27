package com.boldfaced7.kafkacdcpractice.application.port.in;

public interface DeleteUseCase {
    void delete(DeleteCommand command);
}
