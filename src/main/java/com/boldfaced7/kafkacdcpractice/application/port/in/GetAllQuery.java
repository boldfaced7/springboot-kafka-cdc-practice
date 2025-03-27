package com.boldfaced7.kafkacdcpractice.application.port.in;

import com.boldfaced7.kafkacdcpractice.domain.Model;

import java.util.List;

public interface GetAllQuery {
    List<Model> getAll();
}
