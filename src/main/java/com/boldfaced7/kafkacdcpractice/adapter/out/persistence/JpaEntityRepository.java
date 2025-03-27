package com.boldfaced7.kafkacdcpractice.adapter.out.persistence;

import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface JpaEntityRepository extends Repository<JpaEntity, Long> {
    JpaEntity save(JpaEntity entity);
    Optional<JpaEntity> findById(Long id);
    List<JpaEntity> findAll();
    void deleteById(Long id);
}
