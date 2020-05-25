package com.booking.usecases;

import com.booking.entity.booking.Booking;
import com.booking.interfaces.repository.provider.BookingsProvider;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CreateBooking {

    private final BookingsProvider bookingsProvider;

    public Booking execute(final Booking booking) {
        return bookingsProvider.saveBooking(booking);
    }
}
