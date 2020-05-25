package com.booking.interfaces.adapter.http.exceptions;

import java.io.IOException;
import java.io.UncheckedIOException;

public class NoBookingFoundException extends UncheckedIOException {

    public NoBookingFoundException() {
        super("There is no Booking with this Id.", new IOException());
    }
}
