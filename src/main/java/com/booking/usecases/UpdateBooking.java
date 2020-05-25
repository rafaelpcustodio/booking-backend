package com.booking.usecases;

import com.booking.entity.booking.Booking;
import com.booking.interfaces.adapter.http.exceptions.NoBookingFoundException;
import com.booking.interfaces.repository.provider.BookingsProvider;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UpdateBooking {

    private final BookingsProvider bookingsProvider;

    public void execute(final Booking bookingToSave, final String bookingId) {
        bookingsProvider.getBookingById(bookingId).map(bookingFromBase ->
            bookingsProvider.saveBooking(this.mergeBooking(bookingToSave, bookingFromBase))
        ).orElseThrow(NoBookingFoundException::new);
    }

    private Booking mergeBooking(final Booking bookingToSave, final Booking bookingFromBase) {
        return Booking.builder()
                .bookingId(bookingFromBase.getBookingId())
                .waitingTime(bookingToSave.getWaitingTime() != null ? bookingToSave.getWaitingTime() : bookingFromBase.getWaitingTime())
                .tripWayPoints(bookingToSave.getTripWayPoints() != null && !bookingToSave.getTripWayPoints().isEmpty() ? bookingToSave.getTripWayPoints() : bookingFromBase.getTripWayPoints())
                .rating(bookingToSave.getRating() != null ? bookingToSave.getRating() : bookingFromBase.getRating())
                .price(bookingToSave.getPrice() != null ? bookingToSave.getPrice() : bookingFromBase.getPrice())
                .pickupTime(bookingToSave.getPickupTime() != null ? bookingToSave.getPickupTime() : bookingFromBase.getPickupTime())
                .passengerName(bookingToSave.getPassengerName() != null ? bookingToSave.getPassengerName() : bookingFromBase.getPassengerName())
                .passengerContactNumber(bookingToSave.getPassengerContactNumber() != null ? bookingToSave.getPassengerContactNumber() : bookingFromBase.getPassengerContactNumber())
                .noOfPassengers(bookingToSave.getNoOfPassengers() != null ? bookingToSave.getNoOfPassengers() : bookingFromBase.getNoOfPassengers())
                .asap(bookingToSave.getAsap() != null ? bookingToSave.getAsap() : bookingFromBase.getAsap())
                .build();
    }
}
