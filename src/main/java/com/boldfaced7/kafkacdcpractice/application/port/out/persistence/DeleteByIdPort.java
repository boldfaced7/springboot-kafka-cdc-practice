package com.boldfaced7.kafkacdcpractice.application.port.out.persistence;

import com.boldfaced7.kafkacdcpractice.domain.Model;

public interface DeleteByIdPort {
    void deleteById(Model.Id id);
}
