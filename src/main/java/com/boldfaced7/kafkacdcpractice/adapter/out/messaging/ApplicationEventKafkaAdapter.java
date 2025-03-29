package com.boldfaced7.kafkacdcpractice.adapter.out.messaging;

import com.boldfaced7.kafkacdcpractice.adapter.out.event.CreatedApplicationEvent;
import com.boldfaced7.kafkacdcpractice.adapter.out.event.DeletedApplicationEvent;
import com.boldfaced7.kafkacdcpractice.adapter.out.event.UpdatedApplicationEvent;
import com.boldfaced7.kafkacdcpractice.adapter.out.messaging.dto.MessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class ApplicationEventKafkaAdapter {

    private final KafkaProducer kafkaProducer;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Async
    public void onCreatedApplicationEvent(CreatedApplicationEvent applicationEvent) {
        var message = MessageMapper.toMessage(applicationEvent.getEvent());
        kafkaProducer.sendMessage(message);
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Async
    public void onUpdatedApplicationEvent(UpdatedApplicationEvent applicationEvent) {
        var message = MessageMapper.toMessage(applicationEvent.getEvent());
        kafkaProducer.sendMessage(message);
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Async
    public void onDeletedApplicationEvent(DeletedApplicationEvent applicationEvent) {
        var message = MessageMapper.toMessage(applicationEvent.getEvent());
        kafkaProducer.sendMessage(message);
    }
}
