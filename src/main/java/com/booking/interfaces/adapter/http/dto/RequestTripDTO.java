package com.booking.interfaces.adapter.http.dto;

import com.booking.entity.booking.Booking;
import com.booking.entity.trip.Trip;
import java.math.BigDecimal;
import java.util.Collections;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class RequestTripDTO {
  private String id;
  private String placeName;
  private BigDecimal originalPrice;
  private BigDecimal discountPrice;
  private Boolean isSale;
  private String imageUrl;
  private String description;
  private String grade;
  public static Trip toEntity(final RequestTripDTO request) {
    return Trip.builder()
        .description(request.getDescription())
        .discountPrice(request.getDiscountPrice())
        .grade(request.getGrade())
        .imageUrl(request.getImageUrl())
        .isSale(request.getIsSale())
        .originalPrice(request.getOriginalPrice())
        .placeName(request.getPlaceName())
        .discountPrice(request.getDiscountPrice())
        .build();
  }
}
