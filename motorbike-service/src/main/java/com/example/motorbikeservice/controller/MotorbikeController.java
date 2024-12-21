package com.example.motorbikeservice.controller;

import com.example.motorbikeservice.model.Motorbike;
import com.example.motorbikeservice.service.MotorbikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/motorbikes")
@RequiredArgsConstructor
public class MotorbikeController {
    private final MotorbikeService motorbikeService;

    @GetMapping
    public List<Motorbike> getAllMotorbikes() {
        return motorbikeService.getAllMotorbikes();
    }

    @GetMapping("/{id}")
    public Optional<Motorbike> getMotorbikeById(@PathVariable Long id) {
        return motorbikeService.getMotorbikeById(id);
    }

    @PostMapping
    public Motorbike createMotorbike(@RequestBody Motorbike motorbike) {
        return motorbikeService.createMotorbike(motorbike);
    }

    @DeleteMapping("/{id}")
    public void deleteMotorbike(@PathVariable Long id) {
        motorbikeService.deleteMotorbike(id);
    }

    // Endpoint to filter motorbikes by brand and/or model
    @GetMapping("/filter")
    public List<Motorbike> filterMotorbikes(@RequestParam(required = false) String brand,
                                            @RequestParam(required = false) String model) {
        return motorbikeService.filterMotorbikes(brand, model);
    }

    // Endpoint to update an existing motorbike
    @PutMapping("/{id}")
    public Motorbike updateMotorbike(@PathVariable Long id, @RequestBody Motorbike motorbike) {
        Motorbike updatedMotorbike = motorbikeService.updateMotorbike(id, motorbike);
        if (updatedMotorbike != null) {
            return updatedMotorbike;
        }
        // Return a 404 error or throw an exception if the motorbike doesn't exist
        return null;  // Or return a ResponseEntity with NOT_FOUND status
    }
}
