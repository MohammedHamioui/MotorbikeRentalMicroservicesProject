package com.example.motorbikeservice.service;

import com.example.motorbikeservice.model.Motorbike;
import com.example.motorbikeservice.repository.MotorbikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MotorbikeService {
    private final MotorbikeRepository motorbikeRepository;

    public List<Motorbike> getAllMotorbikes() {
        return motorbikeRepository.findAll();
    }

    public Optional<Motorbike> getMotorbikeById(Long id) {
        return motorbikeRepository.findById(id);
    }

    public Motorbike createMotorbike(Motorbike motorbike) {
        return motorbikeRepository.save(motorbike);
    }

    public void deleteMotorbike(Long id) {
        motorbikeRepository.deleteById(id);
    }

    // Method to filter motorbikes by brand and/or model
    public List<Motorbike> filterMotorbikes(String brand, String model) {
        return motorbikeRepository.findByBrandAndModel(brand, model);
    }

    // Method to update an existing motorbike
    public Motorbike updateMotorbike(Long id, Motorbike motorbikeDetails) {
        Optional<Motorbike> existingMotorbike = motorbikeRepository.findById(id);
        if (existingMotorbike.isPresent()) {
            Motorbike motorbike = existingMotorbike.get();
            motorbike.setBrand(motorbikeDetails.getBrand());
            motorbike.setModel(motorbikeDetails.getModel());
            motorbike.setPrice(motorbikeDetails.getPrice());
            motorbike.setYear(motorbikeDetails.getYear());
            return motorbikeRepository.save(motorbike);
        }
        // Throw an exception or return null if not found
        return null;  // Or throw a custom exception, e.g., MotorbikeNotFoundException
    }
}
