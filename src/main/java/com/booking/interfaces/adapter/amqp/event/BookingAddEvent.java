package com.booking.interfaces.adapter.amqp.event;

import com.booking.entity.booking.Booking;
import com.booking.interfaces.adapter.amqp.enums.BookingEventType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static com.booking.interfaces.adapter.amqp.enums.BookingEventType.ADD;

@RequiredArgsConstructor
public class BookingAddEvent extends AbstractBookingEvent {
    @Getter
    private final Booking booking;
    @Override
    public BookingEventType getType() {
        return ADD;
    }
}