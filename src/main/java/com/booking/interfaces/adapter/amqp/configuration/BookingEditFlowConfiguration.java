package com.booking.interfaces.adapter.amqp.configuration;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.booking.interfaces.adapter.amqp.enums.BookingEventType.EDIT;
import static com.booking.interfaces.adapter.amqp.enums.MessageHeader.EVENT_TYPE;

@Configuration
class BookingEditFlowConfiguration {

    @Bean
    Binding bookingEditBinding(final HeadersExchange bookingExchange, final Queue bookingEditQueue) {
        return BindingBuilder
                .bind(bookingEditQueue)
                .to(bookingExchange)
                .where(EVENT_TYPE.getValue())
                .matches(EDIT.getValue());
    }

    @Bean
    Queue bookingEditQueue(@Value("${spring.rabbitmq.queue.bookingEdit}") final String queue) {
        return new Queue(queue);
    }
}
