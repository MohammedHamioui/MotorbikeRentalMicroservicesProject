package com.example.motorbikeservice.repository;

import com.example.motorbikeservice.model.Motorbike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MotorbikeRepository extends JpaRepository<Motorbike, Long> {

    // Custom query for filtering by brand and/or model
    @Query("SELECT m FROM Motorbike m WHERE (:brand IS NULL OR m.brand = :brand) AND (:model IS NULL OR m.model = :model)")
    List<Motorbike> findByBrandAndModel(@Param("brand") String brand, @Param("model") String model);

}
