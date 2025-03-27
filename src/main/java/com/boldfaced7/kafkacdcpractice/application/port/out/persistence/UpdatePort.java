package com.boldfaced7.kafkacdcpractice.application.port.out.persistence;

import com.boldfaced7.kafkacdcpractice.domain.Model;

public interface UpdatePort {
    Model update(Model model);
}
