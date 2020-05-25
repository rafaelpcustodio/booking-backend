package com.booking.entity.booking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Setter
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@Document(collection="booking")
public class Booking {
    @Id
    private String bookingId;
    private String passengerName;
    private String passengerContactNumber;
    private Instant pickupTime;
    private Boolean asap;
    private Integer waitingTime;
    private Integer noOfPassengers;
    private BigDecimal price;
    private Integer rating;
    private Instant createdOn;
    private Instant lastModifiedOn;
    private List<TripWayPoint> tripWayPoints;
}
