package com.booking.interfaces.adapter.amqp.consumer;

import com.booking.interfaces.adapter.amqp.event.BookingAddEvent;
import com.booking.interfaces.adapter.amqp.event.BookingDeleteEvent;
import com.booking.interfaces.adapter.amqp.event.BookingEditEvent;
import com.booking.interfaces.adapter.amqp.event.BookingEvent;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ConsumerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerService.class);

    @Transactional
    @RabbitListener(queues = "${spring.rabbitmq.queue.bookingAdd}")
    public void handleBookingAddQueueMessage(final BookingAddEvent event) {
        LOGGER.info(String.format("Message received in Queue add: %s", event));
    }

    @Transactional
    @RabbitListener(queues = "${spring.rabbitmq.queue.bookingDelete}")
    public void handleBookingDeleteQueueMessage(final BookingDeleteEvent event) {
        LOGGER.info(String.format("Message received in Queue delete: %s", event));
    }

    @Transactional
    @RabbitListener(queues = "${spring.rabbitmq.queue.bookingEdit}")
    public void handleBookingEditQueueMessage(final BookingEditEvent event) {
        LOGGER.info(String.format("Message received in Queue edit: %s", event));
    }

    @Transactional
    @RabbitListener(queues = "${spring.rabbitmq.queue.audit}")
    public void handleBookingAuditQueueMessage(final BookingEvent event) {
        LOGGER.info(String.format("Message received in Queue audit: %s", event));
    }
}
