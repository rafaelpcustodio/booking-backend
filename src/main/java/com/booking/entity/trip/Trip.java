package com.booking.entity.trip;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
public class Trip {
  @Id
  private String id;
  private String placeName;
  private BigDecimal originalPrice;
  private BigDecimal discountPrice;
  private String imageUrl;
  private String description;
  private String grade;
  private Boolean isSale;
}
