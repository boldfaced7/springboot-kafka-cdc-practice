package com.boldfaced7.kafkacdcpractice.adapter.in.web;

import com.boldfaced7.kafkacdcpractice.application.port.in.GetByIdCommand;
import com.boldfaced7.kafkacdcpractice.application.port.in.GetByIdQuery;
import com.boldfaced7.kafkacdcpractice.domain.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/model")
@RequiredArgsConstructor
public class GetByIdController {

    private final GetByIdQuery getByIdQuery;

    @GetMapping("/{id}")
    public ResponseEntity<Response> getById(
            @PathVariable Long id
    ) {
        var command = new GetByIdCommand(id);
        var found = getByIdQuery.getById(command);
        var response = Response.from(found);
        return ResponseEntity.ok(response);
    }

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
