package com.boldfaced7.kafkacdcpractice.adapter.out.event;

import com.boldfaced7.kafkacdcpractice.domain.event.DeletedEvent;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class DeletedApplicationEvent extends ApplicationEvent {

    private final Long id;
    private final DeletedEvent event;

    public DeletedApplicationEvent(
            Object source,
            Long id,
            DeletedEvent event
    ) {
        super(source);
        this.id = id;
        this.event = event;
    }
}
