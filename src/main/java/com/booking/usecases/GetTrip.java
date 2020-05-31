package com.booking.usecases;

import com.booking.entity.trip.Trip;
import com.booking.interfaces.repository.provider.TripsProvider;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class GetTrip {

  private final TripsProvider tripsProvider;

  public List<Trip> execute() {
    return tripsProvider.getAllTrips();
  }

}
