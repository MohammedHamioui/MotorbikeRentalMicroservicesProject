package com.example.motorbikeservice.repository;

import com.example.motorbikeservice.model.Motorbike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotorbikeRepository extends JpaRepository<Motorbike, Long> {
}
