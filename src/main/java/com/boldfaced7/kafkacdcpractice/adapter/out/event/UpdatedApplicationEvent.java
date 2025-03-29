package com.boldfaced7.kafkacdcpractice.adapter.out.event;

import com.boldfaced7.kafkacdcpractice.domain.event.UpdatedEvent;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class UpdatedApplicationEvent extends ApplicationEvent {

    private final Long id;
    private final UpdatedEvent event;

    public UpdatedApplicationEvent(
            Object source,
            Long id,
            UpdatedEvent event
    ) {
        super(source);
        this.id = id;
        this.event = event;
    }
}
