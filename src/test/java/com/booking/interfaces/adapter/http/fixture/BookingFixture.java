package com.booking.interfaces.adapter.http.fixture;

import com.booking.entity.booking.Booking;
import com.booking.entity.booking.TripWayPoint;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class BookingFixture {

    public static Booking validBooking() {
        return Booking.builder()
                .bookingId("5c38e1e7-25a2-4411-abbf-d529775c60c6")
                .asap(true)
                .noOfPassengers(1)
                .passengerContactNumber("19996478232")
                .passengerName("Rafael Custodio")
                .pickupTime(OffsetDateTime.of(LocalDateTime.of(2020,4,28,3,3,3), ZoneOffset.UTC).toInstant())
                .price(BigDecimal.valueOf(250))
                .rating(8)
                .tripWayPoints(Collections.singletonList(TripWayPoint.builder()
                        .tripWayPointTimestamp(Instant.ofEpochMilli(5))
                        .lastStop(true)
                        .lat(2.0)
                        .lng(3.0)
                        .locality("Campinas")
                        .build()
                ))
                .waitingTime(50)
                .build();
    }

    public static List<Booking> validBookingEntities() {
        return Arrays.asList(
                Booking.builder()
                        .bookingId("5c38e1e7-25a2-4411-abbf-d529775c60c6")
                        .asap(true)
                        .noOfPassengers(1)
                        .passengerContactNumber("19996478232")
                        .passengerName("Rafael Custodio")
                        .pickupTime(OffsetDateTime.of(LocalDateTime.of(2020,4,28,3,3,3), ZoneOffset.UTC).toInstant())
                        .price(BigDecimal.valueOf(250))
                        .rating(8)
                        .tripWayPoints(Collections.singletonList(TripWayPoint.builder()
                                .tripWayPointTimestamp(Instant.ofEpochMilli(5))
                                .lastStop(true)
                                .lat(2.0)
                                .lng(3.0)
                                .locality("Campinas")
                                .build()
                        ))
                        .waitingTime(50)
                        .build(),
                Booking.builder()
                        .bookingId("5c38e1e7-25a2-4411-abbf-d529775c60c6")
                        .asap(false)
                        .noOfPassengers(2)
                        .passengerContactNumber("19981111313")
                        .passengerName("Sandra Helena")
                        .pickupTime(OffsetDateTime.of(LocalDateTime.of(2020,4,28,3,3,3), ZoneOffset.UTC).toInstant())
                        .price(BigDecimal.valueOf(200))
                        .rating(9)
                        .tripWayPoints(Collections.singletonList(TripWayPoint.builder()
                                .tripWayPointTimestamp(Instant.ofEpochMilli(5))
                                .lastStop(true)
                                .lat(2.0)
                                .lng(3.0)
                                .locality("Campinas")
                                .build()
                        ))
                        .waitingTime(55)
                        .build()
        );
    }
}
