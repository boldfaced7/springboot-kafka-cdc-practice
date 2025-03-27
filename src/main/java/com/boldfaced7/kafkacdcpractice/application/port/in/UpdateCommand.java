package com.boldfaced7.kafkacdcpractice.application.port.in;

import com.boldfaced7.kafkacdcpractice.domain.Model;

public record UpdateCommand(
        Model.Id id,
        Model.Content content
) {

    public UpdateCommand(
            Long id,
            String content
    ) {
        this(
                new Model.Id(id),
                new Model.Content(content)
        );
    }
}
