package com.example.reservationservice.service;

import com.example.reservationservice.model.Reservation;
import com.example.reservationservice.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    // Method to filter reservations by client name
    public List<Reservation> getReservationsByClientName(String clientName) {
        return reservationRepository.findByClientName(clientName);
    }

    // Method to update a reservation
    public Reservation updateReservation(Long id, Reservation updatedReservation) {
        Optional<Reservation> existingReservationOpt = reservationRepository.findById(id);

        if (existingReservationOpt.isPresent()) {
            Reservation existingReservation = existingReservationOpt.get();

            // Update the fields
            existingReservation.setClientId(updatedReservation.getClientId());
            existingReservation.setMotorbikeId(updatedReservation.getMotorbikeId());
            existingReservation.setStartDate(updatedReservation.getStartDate());
            existingReservation.setEndDate(updatedReservation.getEndDate());
            existingReservation.setClientName(updatedReservation.getClientName());

            // Save the updated reservation
            return reservationRepository.save(existingReservation);
        } else {
            // If the reservation does not exist, you can return null or throw an exception
            return null;  // Or throw a custom exception to handle it properly
        }
    }
}
