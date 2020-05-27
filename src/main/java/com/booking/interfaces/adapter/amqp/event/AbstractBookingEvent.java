package com.booking.interfaces.adapter.amqp.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@RequiredArgsConstructor
abstract class AbstractBookingEvent implements Serializable, BookingEvent {
    @Getter
    private final UUID id;

    AbstractBookingEvent() {
        this.id = UUID.randomUUID();
    }
}