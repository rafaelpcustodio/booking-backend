package com.booking.interfaces.repository.provider;

import com.booking.entity.trip.Trip;
import com.booking.interfaces.repository.database.TripRepositoryDatabase;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class TripsProvider {

  private TripRepositoryDatabase tripRepositoryDatabase;

  public List<Trip> getAllTrips() {
    return tripRepositoryDatabase.findAll();
  }

  public Trip saveTrip(final Trip trip) {
    return tripRepositoryDatabase.save(trip);
  }
}
