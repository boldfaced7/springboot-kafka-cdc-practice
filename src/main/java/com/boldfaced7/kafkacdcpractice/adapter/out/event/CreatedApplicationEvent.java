package com.boldfaced7.kafkacdcpractice.adapter.out.event;

import com.boldfaced7.kafkacdcpractice.domain.event.CreatedEvent;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class CreatedApplicationEvent extends ApplicationEvent {

    private final Long id;
    private final CreatedEvent event;

    public CreatedApplicationEvent(
            Object source,
            Long id,
            CreatedEvent event
    ) {
        super(source);
        this.id = id;
        this.event = event;
    }
}
