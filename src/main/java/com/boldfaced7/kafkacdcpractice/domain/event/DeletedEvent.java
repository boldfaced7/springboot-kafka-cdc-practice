package com.boldfaced7.kafkacdcpractice.domain.event;

import com.boldfaced7.kafkacdcpractice.domain.Model;

public record DeletedEvent(
        Model.Id id
) {}
