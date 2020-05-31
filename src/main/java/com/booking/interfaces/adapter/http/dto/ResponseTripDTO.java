package com.booking.interfaces.adapter.http.dto;

import com.booking.entity.booking.Booking;
import com.booking.entity.trip.Trip;
import java.math.BigDecimal;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
public class ResponseTripDTO {
  private String id;
  private String placeName;
  private BigDecimal originalPrice;
  private BigDecimal discountPrice;
  private Boolean isSale;
  private String imageUrl;
  private String description;
  private String grade;

  public static ResponseTripDTO toResponse(final Trip tripEntity) {
    return ResponseTripDTO.builder()
        .description(tripEntity.getDescription())
        .discountPrice(tripEntity.getDiscountPrice())
        .grade(tripEntity.getGrade())
        .imageUrl(tripEntity.getImageUrl())
        .isSale(tripEntity.getIsSale())
        .originalPrice(tripEntity.getOriginalPrice())
        .placeName(tripEntity.getPlaceName())
        .discountPrice(tripEntity.getDiscountPrice())
        .build();
  }

  public static List<ResponseTripDTO> toResponseList(final List<Trip> tripsEntity) {
    if(!tripsEntity.isEmpty()) {
      return tripsEntity.stream()
          .map(ResponseTripDTO::toResponse)
          .collect(Collectors.toList());
    }
    return Collections.emptyList();
  }
}
