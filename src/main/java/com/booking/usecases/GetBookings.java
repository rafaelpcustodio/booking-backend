package com.booking.usecases;

import com.booking.entity.booking.Booking;
import com.booking.interfaces.adapter.http.exceptions.NoBookingFoundException;
import com.booking.interfaces.repository.provider.BookingsProvider;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class GetBookings {

    private final BookingsProvider bookingsProvider;

    public List<Booking> execute() {
        return bookingsProvider.getAllBookings();
    }

    public Booking executeWith(final String bookingId) {
        return bookingsProvider.getBookingById(bookingId).orElseThrow(NoBookingFoundException::new);
    }

}
