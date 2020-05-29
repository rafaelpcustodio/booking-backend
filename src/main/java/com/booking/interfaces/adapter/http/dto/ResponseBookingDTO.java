package com.booking.interfaces.adapter.http.dto;

import com.booking.entity.booking.Booking;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
public class ResponseBookingDTO {
    private String id;
    private String passengerName;
    private String passengerContactNumber;
    private OffsetDateTime pickupTime;
    private Boolean asap = true;
    private Integer waitingTime;
    private Integer noOfPassengers;
    private BigDecimal price;
    private Integer rating;
    private List<TripWayPointDTO> tripWayPoints;

    public static ResponseBookingDTO toResponse(final Booking bookingEntity) {
        return ResponseBookingDTO.builder()
                .id(bookingEntity.getBookingId())
                .waitingTime(bookingEntity.getWaitingTime())
                .tripWayPoints(TripWayPointDTO.toResponseList(bookingEntity.getTripWayPoints()).orElse(Collections.emptyList()))
                .rating(bookingEntity.getRating())
                .price(bookingEntity.getPrice())
                .pickupTime(bookingEntity.getPickupTime().atOffset(ZoneOffset.UTC))
                .passengerName(bookingEntity.getPassengerName())
                .passengerContactNumber(bookingEntity.getPassengerContactNumber())
                .noOfPassengers(bookingEntity.getNoOfPassengers())
                .asap(bookingEntity.getAsap())
                .build();
    }

    public static List<ResponseBookingDTO> toResponseList(final List<Booking> bookingsEntity) {
        if(!bookingsEntity.isEmpty()) {
            return bookingsEntity.stream()
                    .map(ResponseBookingDTO::toResponse)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
