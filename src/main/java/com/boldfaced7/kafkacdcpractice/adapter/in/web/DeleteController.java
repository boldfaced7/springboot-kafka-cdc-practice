package com.boldfaced7.kafkacdcpractice.adapter.in.web;

import com.boldfaced7.kafkacdcpractice.application.port.in.DeleteCommand;
import com.boldfaced7.kafkacdcpractice.application.port.in.DeleteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/model")
@RequiredArgsConstructor
public class DeleteController {

    private final DeleteUseCase deleteUseCase;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        var command = new DeleteCommand(id);
        deleteUseCase.delete(command);
        return ResponseEntity.ok().build();
    }
}
