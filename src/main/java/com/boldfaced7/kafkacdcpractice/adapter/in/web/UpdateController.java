package com.boldfaced7.kafkacdcpractice.adapter.in.web;

import com.boldfaced7.kafkacdcpractice.application.port.in.UpdateCommand;
import com.boldfaced7.kafkacdcpractice.application.port.in.UpdateUseCase;
import com.boldfaced7.kafkacdcpractice.domain.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/model")
@RequiredArgsConstructor
public class UpdateController {

    private final UpdateUseCase updateUseCase;

    @PutMapping("/{id}")
    public ResponseEntity<Response> update(
            @PathVariable Long id,
            @RequestBody Request request
    ) {
        var command = new UpdateCommand(id, request.content());
        var updated = updateUseCase.update(command);
        var response = Response.from(updated);
        return ResponseEntity.ok(response);
    }

    public record Request(String content) {}

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
