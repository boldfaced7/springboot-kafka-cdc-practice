package com.boldfaced7.kafkacdcpractice.adapter.out.persistence;

import com.boldfaced7.kafkacdcpractice.domain.Model;

public class ModelMapper {

    public static Model toModel(JpaEntity entity) {
        return new Model(
                entity.getId(),
                entity.getUserId(),
                entity.getUserAge(),
                entity.getUserName(),
                entity.getContent(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public static JpaEntity toEntity(Model model) {
        return new JpaEntity(
                model.getId(),
                model.getUserId(),
                model.getUserAge(),
                model.getUserName(),
                model.getContent(),
                model.getCreatedAt(),
                model.getUpdatedAt()
        );
    }
}
