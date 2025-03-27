package com.boldfaced7.kafkacdcpractice.application.port.out.persistence;

import com.boldfaced7.kafkacdcpractice.domain.Model;

import java.util.Optional;

public interface FindByIdPort {
    Optional<Model> findById(Model.Id id);
}
