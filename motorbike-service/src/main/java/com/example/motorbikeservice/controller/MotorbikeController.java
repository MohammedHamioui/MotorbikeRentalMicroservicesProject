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
}
