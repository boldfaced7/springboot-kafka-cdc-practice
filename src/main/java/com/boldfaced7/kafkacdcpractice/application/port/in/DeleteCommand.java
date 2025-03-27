package com.boldfaced7.kafkacdcpractice.application.port.in;

import com.boldfaced7.kafkacdcpractice.domain.Model;

public record DeleteCommand(
        Model.Id id
) {

    public DeleteCommand(Long id) {
        this(new Model.Id(id));
    }
}
