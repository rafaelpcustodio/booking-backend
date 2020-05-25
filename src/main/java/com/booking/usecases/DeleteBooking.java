package com.booking.usecases;

import com.booking.interfaces.repository.provider.BookingsProvider;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class DeleteBooking {

    private final BookingsProvider bookingsProvider;

    public void execute(final String bookingId) {
        bookingsProvider.deleteBookingById(bookingId);
    }
}
