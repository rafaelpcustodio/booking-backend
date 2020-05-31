package com.booking.interfaces.repository.database;

import com.booking.entity.trip.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TripRepositoryDatabase extends MongoRepository<Trip, String> {

}
