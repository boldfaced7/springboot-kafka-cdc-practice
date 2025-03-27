package com.boldfaced7.kafkacdcpractice.application.port.out.persistence;

import com.boldfaced7.kafkacdcpractice.domain.Model;

public interface SavePort {
    Model save(Model model);
}
