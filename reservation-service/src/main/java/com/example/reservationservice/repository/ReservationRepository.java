package com.example.reservationservice.repository;

import com.example.reservationservice.model.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ReservationRepository extends MongoRepository<Reservation, Long> {
    // Method to filter reservations by client name
    List<Reservation> findByClientName(String clientName);
}
