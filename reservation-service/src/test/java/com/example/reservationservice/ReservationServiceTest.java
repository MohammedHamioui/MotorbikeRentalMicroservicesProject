package com.example.reservationservice;

import com.example.reservationservice.model.Reservation;
import com.example.reservationservice.repository.ReservationRepository;
import com.example.reservationservice.service.ReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationService reservationService;

    private Reservation reservation;

    @BeforeEach
    public void setUp() {
        reservation = new Reservation(1L, 101L, 2L, "2024-12-01", "2024-12-10", "John Doe");
    }

    @Test
    public void testCreateReservation() {
        // Given
        when(reservationRepository.save(reservation)).thenReturn(reservation);

        // When
        Reservation createdReservation = reservationService.createReservation(reservation);

        // Then
        assertNotNull(createdReservation);
        assertEquals("John Doe", createdReservation.getClientName());
        verify(reservationRepository, times(1)).save(reservation);
    }

    @Test
    public void testUpdateReservation() {
        // Given
        Reservation updatedReservation = new Reservation(1L, 101L, 2L, "2024-12-05", "2024-12-12", "John Doe Updated");
        when(reservationRepository.findById(1L)).thenReturn(Optional.of(reservation));
        when(reservationRepository.save(updatedReservation)).thenReturn(updatedReservation);

        // When
        Reservation result = reservationService.updateReservation(1L, updatedReservation);

        // Then
        assertNotNull(result);
        assertEquals("John Doe Updated", result.getClientName());
        verify(reservationRepository, times(1)).findById(1L);
        verify(reservationRepository, times(1)).save(updatedReservation);
    }

    @Test
    public void testUpdateReservation_NotFound() {
        // Given
        Reservation updatedReservation = new Reservation(1L, 101L, 2L, "2024-12-05", "2024-12-12", "John Doe Updated");
        when(reservationRepository.findById(1L)).thenReturn(Optional.empty());

        // When
        Reservation result = reservationService.updateReservation(1L, updatedReservation);

        // Then
        assertNull(result);
        verify(reservationRepository, times(1)).findById(1L);
    }

    @Test
    public void testDeleteReservation() {
        // When
        reservationService.deleteReservation(1L);

        // Then
        verify(reservationRepository, times(1)).deleteById(1L);
    }
}
