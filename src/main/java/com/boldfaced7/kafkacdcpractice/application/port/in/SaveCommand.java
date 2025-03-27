package com.boldfaced7.kafkacdcpractice.application.port.in;

import com.boldfaced7.kafkacdcpractice.domain.Model;

public record SaveCommand(
        Model.UserId userId,
        Model.UserAge userAge,
        Model.UserName userName,
        Model.Content content
) {



    public SaveCommand(
            Long userId,
            Integer userAge,
            String userName,
            String content
    ) {
        this(
                new Model.UserId(userId),
                new Model.UserAge(userAge),
                new Model.UserName(userName),
                new Model.Content(content)
        );
    }

    public Model toModel() {
        return Model.createModel(
                userId,
                userAge,
                userName,
                content
        );
    }
}
