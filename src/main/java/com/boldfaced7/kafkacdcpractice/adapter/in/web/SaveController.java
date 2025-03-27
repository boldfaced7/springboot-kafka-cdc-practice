package com.boldfaced7.kafkacdcpractice.adapter.in.web;

import com.boldfaced7.kafkacdcpractice.application.port.in.SaveCommand;
import com.boldfaced7.kafkacdcpractice.application.port.in.SaveUseCase;
import com.boldfaced7.kafkacdcpractice.domain.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/model")
@RequiredArgsConstructor
public class SaveController {

    private final SaveUseCase saveUseCase;

    @PostMapping
    public ResponseEntity<Response> update(
            @RequestBody Request request
    ) {
        var command = toCommand(request);
        var saved = saveUseCase.save(command);
        var response = Response.from(saved);
        return ResponseEntity.ok(response);
    }

    private static SaveCommand toCommand(Request request) {
        return new SaveCommand(
                request.userId(),
                request.userAge(),
                request.userName(),
                request.content()
        );
    }

    public record Request(
            Long userId,
            Integer userAge,
            String userName,
            String content
    ) {}

    public record Response(
            Long id,
            Long userId,
            Integer userAge,
            String userName,
            String content,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        public static Response from(Model model) {
            return new Response(
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
}
