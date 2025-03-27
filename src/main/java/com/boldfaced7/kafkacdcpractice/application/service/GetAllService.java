package com.boldfaced7.kafkacdcpractice.application.service;

import com.boldfaced7.kafkacdcpractice.application.port.in.GetAllQuery;
import com.boldfaced7.kafkacdcpractice.application.port.out.persistence.FindAllPort;
import com.boldfaced7.kafkacdcpractice.domain.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllService implements GetAllQuery {

    private final FindAllPort findAllPort;

    @Override
    public List<Model> getAll() {
        return findAllPort.findAll();
    }
}
