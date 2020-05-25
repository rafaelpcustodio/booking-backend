package com.booking.interfaces.adapter.http.dto;

import com.booking.entity.booking.Booking;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class RequestBookingDTO {
    private String passengerName;
    private String passengerContactNumber;
    private OffsetDateTime pickupTime;
    private Boolean asap;
    private Integer waitingTime;
    private Integer noOfPassengers;
    private BigDecimal price;
    private Integer rating;
    private List<TripWayPointDTO> tripWayPoints;
    public static Booking toEntity(final RequestBookingDTO request) {
        return Booking.builder()
                .waitingTime(request.getWaitingTime())
                .tripWayPoints(TripWayPointDTO.toEntityList(request.getTripWayPoints()).orElse(Collections.emptyList()))
                .rating(request.getRating())
                .price(request.getPrice())
                .pickupTime(request.getPickupTime() != null ? request.getPickupTime().toInstant() : null)
                .passengerName(request.getPassengerName())
                .passengerContactNumber(request.getPassengerContactNumber())
                .noOfPassengers(request.getNoOfPassengers())
                .asap(request.getAsap())
                .build();
    }
}
