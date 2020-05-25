package com.booking.entity.booking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import java.time.Instant;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
public class TripWayPoint {
    @Id
    private String tripWayPointId;
    private Boolean lastStop;
    private String locality;
    private Double lat;
    private Double lng;
    private Instant tripWayPointTimestamp;
}
