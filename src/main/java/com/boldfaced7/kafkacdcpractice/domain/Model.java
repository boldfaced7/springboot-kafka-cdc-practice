package com.boldfaced7.kafkacdcpractice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Model {

    private Long id;
    private final Long userId;
    private final Integer userAge;
    private final String userName;
    private String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public static Model createModel(
            UserId userId,
            UserAge userAge,
            UserName userName,
            Content content
    ) {
        return new Model(
                null,
                userId.value(),
                userAge.value(),
                userName.value(),
                content.value(),
                null,
                null
        );
    }

    public Model update(Content content) {
        return new Model(
                id,
                userId,
                userAge,
                userName,
                content.value(),
                createdAt,
                LocalDateTime.now()
        );
    }

    public record Id(Long value) {}
    public record UserId(Long value) {}
    public record UserAge(Integer value) {}
    public record UserName(String value) {}
    public record Content(String value) {}
}
