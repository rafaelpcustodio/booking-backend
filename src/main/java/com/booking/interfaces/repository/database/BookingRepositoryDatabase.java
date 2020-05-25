package com.booking.interfaces.repository.database;

import com.booking.entity.booking.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookingRepositoryDatabase extends MongoRepository<Booking, String> {
}
