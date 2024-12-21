package com.example.car_management.controller;

import com.example.car_management.model.Car;
import com.example.car_management.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    // Create a new car
    @PostMapping
    public Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    // Get all cars (with pagination and sorting)
    @GetMapping
    public Page<Car> getCars(@RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "10") int size,
                             @RequestParam(defaultValue = "carName") String sortBy) {
        return carService.getCarsPaginated(page, size, sortBy);
    }

    // Get car by ID
    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    // Update a car
    @PutMapping("/{id}")
    public Car updateCar(@PathVariable Long id, @RequestBody Car car) {
        return carService.updateCar(id, car);
    }

    // Delete a car
    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }

    // Global Search
    @GetMapping("/search")
    public List<Car> searchCars(@RequestParam String query) {
        return carService.searchCars(query);
    }
}
