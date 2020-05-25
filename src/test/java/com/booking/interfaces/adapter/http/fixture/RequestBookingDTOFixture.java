package com.booking.interfaces.adapter.http.fixture;

import com.booking.interfaces.adapter.http.dto.RequestBookingDTO;
import com.booking.interfaces.adapter.http.dto.TripWayPointDTO;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Collections;

public class RequestBookingDTOFixture {

    public static RequestBookingDTO validBooking() {
        return RequestBookingDTO.builder()
                .asap(true)
                .noOfPassengers(1)
                .passengerContactNumber("19996478232")
                .pickupTime(OffsetDateTime.of(LocalDateTime.of(2020,4,28,3,3,3), ZoneOffset.UTC))
                .passengerName("Rafael Custodio")
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
}
