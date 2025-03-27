package com.boldfaced7.kafkacdcpractice.adapter.in.web;

import com.boldfaced7.kafkacdcpractice.application.port.in.GetAllQuery;
import com.boldfaced7.kafkacdcpractice.domain.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/model")
@RequiredArgsConstructor
public class GetAllController {

    private final GetAllQuery getAllQuery;

    @GetMapping
    public ResponseEntity<List<Response>> getAll() {
        return getAllQuery.getAll().stream()
                .map(Response::from)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        ResponseEntity::ok
                ));
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
