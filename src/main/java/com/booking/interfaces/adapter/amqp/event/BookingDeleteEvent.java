package com.booking.interfaces.adapter.amqp.event;

import com.booking.entity.booking.Booking;
import com.booking.interfaces.adapter.amqp.enums.BookingEventType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static com.booking.interfaces.adapter.amqp.enums.BookingEventType.DELETE;

@RequiredArgsConstructor
public class BookingDeleteEvent extends AbstractBookingEvent {
    @Getter
    private final Booking booking;
    @Override
    public BookingEventType getType() {
        return DELETE;
    }
}