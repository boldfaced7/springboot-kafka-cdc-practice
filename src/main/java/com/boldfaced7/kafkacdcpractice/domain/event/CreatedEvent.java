package com.boldfaced7.kafkacdcpractice.domain.event;

import com.boldfaced7.kafkacdcpractice.domain.Model;

import java.time.LocalDateTime;

public record CreatedEvent(
        Model.Id id,
        Model.UserId userId,
        Model.UserAge userAge,
        Model.UserName userName,
        Model.Content content,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static CreatedEvent from(Model model) {
        return new CreatedEvent(
                new Model.Id(model.getId()),
                new Model.UserId(model.getUserId()),
                new Model.UserAge(model.getUserAge()),
                new Model.UserName(model.getUserName()),
                new Model.Content(model.getContent()),
                model.getCreatedAt(),
                model.getUpdatedAt()
        );
    }
}
