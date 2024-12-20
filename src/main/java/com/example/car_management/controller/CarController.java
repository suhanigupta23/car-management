package com.example.car_management.controller;

import com.example.car_management.entity.Car;
import com.example.car_management.service.CarService;

import jakarta.validation.Valid; // Ensure this import is present

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    // Search for cars with name, model, or year filters
    @GetMapping("/search")
    public List<Car> searchCars(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String model,
        @RequestParam(required = false) Integer year) {
        
        return carService.searchCars(name, model, year);
    }

    // Endpoint for getting all cars with pagination and sorting
    @GetMapping
    public Page<Car> getAllCars(
        @RequestParam(defaultValue = "0") int page,      // Default page is 0
        @RequestParam(defaultValue = "10") int size,     // Default size is 10
        @RequestParam(defaultValue = "id,asc") String[] sort // Default sorting is by 'id' in ascending order
    ) {
        return carService.getAllCars(page, size, sort);
    }

    // Add a new car with validation on the request body
    @PostMapping
    public ResponseEntity<Car> addCar(@Valid @RequestBody Car car) {  // Use @Valid here
        Car savedCar = carService.saveCar(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCar);
    }
}
