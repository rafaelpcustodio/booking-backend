package com.booking.interfaces.adapter.http.dto;

import com.booking.entity.booking.Booking;
import com.booking.entity.booking.TripWayPoint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class TripWayPointDTO {
    private Boolean lastStop;
    private String locality;
    private Double latitude;
    private Double longitude;
    private Instant tripWayPointTimestamp;

    public static TripWayPoint toEntity(final TripWayPointDTO tripWayPointEntityDTO) {
        return TripWayPoint.builder()
                .lastStop(tripWayPointEntityDTO.getLastStop())
                .lat(tripWayPointEntityDTO.getLatitude())
                .lng(tripWayPointEntityDTO.getLongitude())
                .locality(tripWayPointEntityDTO.getLocality())
                .tripWayPointTimestamp(tripWayPointEntityDTO.getTripWayPointTimestamp())
                .build();
    }

    public static TripWayPointDTO toResponse(final TripWayPoint tripWayPointEntity) {
        return TripWayPointDTO.builder()
                .lastStop(tripWayPointEntity.getLastStop())
                .latitude(tripWayPointEntity.getLat())
                .longitude(tripWayPointEntity.getLng())
                .locality(tripWayPointEntity.getLocality())
                .tripWayPointTimestamp(tripWayPointEntity.getTripWayPointTimestamp())
                .build();
    }

    public static Optional<List<TripWayPointDTO>> toResponseList(final List<TripWayPoint> tripWayPointEntities) {
        if(tripWayPointEntities != null) {
            return Optional.of(tripWayPointEntities.stream()
                    .map(TripWayPointDTO::toResponse)
                    .collect(Collectors.toList()));
        }
        return Optional.empty();
    }

    public static Optional<List<TripWayPoint>> toEntityList(final List<TripWayPointDTO> tripWayPointDTO) {
        if(tripWayPointDTO != null) {
            return Optional.of(tripWayPointDTO.stream()
                    .map(TripWayPointDTO::toEntity)
                    .collect(Collectors.toList()));
        }
        return Optional.empty();
    }

}
