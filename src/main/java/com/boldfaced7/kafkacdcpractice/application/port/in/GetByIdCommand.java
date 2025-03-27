package com.boldfaced7.kafkacdcpractice.application.port.in;

import com.boldfaced7.kafkacdcpractice.domain.Model;

public record GetByIdCommand(
        Model.Id id
) {

    public GetByIdCommand(Long id) {
        this(new Model.Id(id));
    }
}
