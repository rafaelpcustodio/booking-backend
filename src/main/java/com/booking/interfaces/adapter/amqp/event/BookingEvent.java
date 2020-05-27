package com.booking.interfaces.adapter.amqp.event;


import com.booking.interfaces.adapter.amqp.enums.BookingEventType;

import java.util.UUID;

public interface BookingEvent {
    UUID getId();
    BookingEventType getType();
}