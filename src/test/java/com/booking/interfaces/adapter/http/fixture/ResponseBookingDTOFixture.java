package com.booking.interfaces.adapter.http.fixture;

import com.booking.interfaces.adapter.http.dto.ResponseBookingDTO;
import com.booking.interfaces.adapter.http.dto.TripWayPointDTO;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ResponseBookingDTOFixture {

    public static ResponseBookingDTO validBooking() {
        return ResponseBookingDTO.builder()
                .asap(true)
                .noOfPassengers(1)
                .passengerContactNumber("19996478232")
                .passengerName("Rafael Custodio")
                .pickupTime(OffsetDateTime.of(LocalDateTime.of(2020,4,28,3,3,3), ZoneOffset.UTC))
                .price(BigDecimal.valueOf(250))
                .rating(8)
                .tripWayPoints(Collections.singletonList(TripWayPointDTO.builder()
                        .tripWayPointTimestamp(Instant.ofEpochMilli(5))
                        .lastStop(true)
                        .latitude(2.0)
                        .longitude(3.0)
                        .locality("Campinas")
                        .build()
                ))
                .waitingTime(50)
                .build();
    }

    public static List<ResponseBookingDTO> validBookings() {
        return Arrays.asList(
                        ResponseBookingDTO.builder()
                                .asap(true)
                                .noOfPassengers(1)
                                .passengerContactNumber("19996478232")
                                .passengerName("Rafael Custodio")
                                .pickupTime(OffsetDateTime.of(LocalDateTime.of(2020,4,28,3,3,3), ZoneOffset.UTC))
                                .price(BigDecimal.valueOf(250))
                                .rating(8)
                                .tripWayPoints(Collections.singletonList(TripWayPointDTO.builder()
                                        .tripWayPointTimestamp(Instant.ofEpochMilli(5))
                                        .lastStop(true)
                                        .latitude(2.0)
                                        .longitude(3.0)
                                        .locality("Campinas")
                                        .build()
                                ))
                                .waitingTime(50)
                                .build(),
                        ResponseBookingDTO.builder()
                                .asap(false)
                                .noOfPassengers(2)
                                .passengerContactNumber("19981111313")
                                .passengerName("Sandra Helena")
                                .pickupTime(OffsetDateTime.of(LocalDateTime.of(2020,4,28,3,3,3), ZoneOffset.UTC))
                                .price(BigDecimal.valueOf(200))
                                .rating(9)
                                .tripWayPoints(Collections.singletonList(TripWayPointDTO.builder()
                                        .tripWayPointTimestamp(Instant.ofEpochMilli(5))
                                        .lastStop(true)
                                        .latitude(2.0)
                                        .longitude(3.0)
                                        .locality("Campinas")
                                        .build()
                                ))
                                .waitingTime(55)
                                .build()
                );
    }
}
