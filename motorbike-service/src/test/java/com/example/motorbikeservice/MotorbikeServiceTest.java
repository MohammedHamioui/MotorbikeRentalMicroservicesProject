package com.example.motorbikeservice;

import com.example.motorbikeservice.model.Motorbike;
import com.example.motorbikeservice.repository.MotorbikeRepository;
import com.example.motorbikeservice.service.MotorbikeService;
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
public class MotorbikeServiceTest {

    @Mock
    private MotorbikeRepository motorbikeRepository;

    @InjectMocks
    private MotorbikeService motorbikeService;

    private Motorbike motorbike;

    @BeforeEach
    void setUp() {
        motorbike = new Motorbike(1L, "Model X", "Brand Y", 5000, 2021);
    }

    @Test
    public void testGetMotorbikeById() {
        // Given
        when(motorbikeRepository.findById(1L)).thenReturn(Optional.of(motorbike));

        // When
        Optional<Motorbike> foundMotorbike = motorbikeService.getMotorbikeById(1L);

        // Then
        assertTrue(foundMotorbike.isPresent());
        assertEquals(motorbike.getModel(), foundMotorbike.get().getModel());
        verify(motorbikeRepository, times(1)).findById(1L);
    }

    @Test
    public void testCreateMotorbike() {
        // Given
        when(motorbikeRepository.save(motorbike)).thenReturn(motorbike);

        // When
        Motorbike createdMotorbike = motorbikeService.createMotorbike(motorbike);

        // Then
        assertEquals(motorbike.getModel(), createdMotorbike.getModel());
        verify(motorbikeRepository, times(1)).save(motorbike);
    }

    @Test
    public void testDeleteMotorbike() {
        // When
        motorbikeService.deleteMotorbike(1L);

        // Then
        verify(motorbikeRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testUpdateMotorbike() {
        // Given
        motorbike.setPrice(5500); // Update price to 5500
        when(motorbikeRepository.findById(1L)).thenReturn(Optional.of(motorbike));  // Mock finding the motorbike by ID
        when(motorbikeRepository.save(motorbike)).thenReturn(motorbike);  // Mock saving the updated motorbike

        // When
        motorbikeService.updateMotorbike(1L, motorbike);  // Call update with ID and motorbike

        // Then
        verify(motorbikeRepository, times(1)).save(motorbike);  // Verify that save was called once to update the motorbike
    }
}
