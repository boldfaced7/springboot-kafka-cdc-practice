package com.boldfaced7.kafkacdcpractice.application.port.out.persistence;

import com.boldfaced7.kafkacdcpractice.domain.Model;

import java.util.List;

public interface FindAllPort {
    List<Model> findAll();
}
