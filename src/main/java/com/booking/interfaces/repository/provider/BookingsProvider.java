package com.booking.interfaces.repository.provider;

import com.booking.entity.booking.Booking;
import com.booking.interfaces.repository.database.BookingRepositoryDatabase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class BookingsProvider {

    private BookingRepositoryDatabase bookingRepository;

    public Optional<Booking> getBookingById(final String bookingId) {
        return bookingRepository.findById(bookingId);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public void deleteBookingById(final String bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    public Booking saveBooking(final Booking booking) {
        return bookingRepository.save(booking);
    }
}
