package com.booking.interfaces.adapter.http.handler;

import com.booking.interfaces.adapter.http.error.ErrorResponse;
import com.booking.interfaces.adapter.http.exceptions.NoBookingFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NoBookingFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoBookingException(final NoBookingFoundException ex) {
        return ResponseEntity.status(BAD_REQUEST).body(ErrorResponse.builder()
                .message(ex.getMessage()).build());
    }
}
