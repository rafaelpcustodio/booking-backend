package com.booking.usecases;

import com.booking.entity.trip.Trip;
import com.booking.interfaces.repository.provider.TripsProvider;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CreateTrip {

  private final TripsProvider tripsProvider;

  public Trip execute(final Trip trip) {
    return tripsProvider.saveTrip(trip);
  }
}
