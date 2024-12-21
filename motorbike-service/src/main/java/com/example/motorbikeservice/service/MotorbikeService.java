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
}