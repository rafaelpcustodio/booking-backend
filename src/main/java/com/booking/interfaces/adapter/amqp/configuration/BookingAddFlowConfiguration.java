package com.booking.interfaces.adapter.amqp.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.booking.interfaces.adapter.amqp.enums.BookingEventType.ADD;
import static com.booking.interfaces.adapter.amqp.enums.MessageHeader.EVENT_TYPE;

@Configuration
class BookingAddFlowConfiguration {

    @Bean
    Binding bookingAddBinding(final HeadersExchange bookingExchange, final Queue bookingAddQueue) {
        return BindingBuilder
                .bind(bookingAddQueue)
                .to(bookingExchange)
                .where(EVENT_TYPE.getValue())
                .matches(ADD.getValue());
    }

    @Bean
    Queue bookingAddQueue(@Value("${spring.rabbitmq.queue.bookingAdd}") final String queue) {
        return new Queue(queue);
    }
}
