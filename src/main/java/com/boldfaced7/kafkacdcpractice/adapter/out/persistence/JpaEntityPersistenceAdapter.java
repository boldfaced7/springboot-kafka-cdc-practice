package com.boldfaced7.kafkacdcpractice.adapter.out.persistence;

import com.boldfaced7.kafkacdcpractice.application.port.out.persistence.*;
import com.boldfaced7.kafkacdcpractice.domain.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaEntityPersistenceAdapter implements FindByIdPort, FindAllPort, SavePort, DeleteByIdPort, UpdatePort {

    private final JpaEntityRepository jpaEntityRepository;

    @Override
    public void deleteById(Model.Id id) {
        jpaEntityRepository.deleteById(id.value());
    }

    @Override
    public List<Model> findAll() {
        return jpaEntityRepository.findAll().stream()
                .map(ModelMapper::toModel)
                .toList();
    }

    @Override
    public Optional<Model> findById(Model.Id id) {
        return jpaEntityRepository.findById(id.value())
                .map(ModelMapper::toModel);
    }

    @Override
    public Model save(Model model) {
        var entity = ModelMapper.toEntity(model);
        var saved = jpaEntityRepository.save(entity);
        return ModelMapper.toModel(saved);
    }

    @Override
    public Model update(Model model) {
        var entity = ModelMapper.toEntity(model);
        var updated = jpaEntityRepository.save(entity);
        return ModelMapper.toModel(updated);
    }
}
