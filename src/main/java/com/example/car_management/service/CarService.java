package com.example.car_management.service;

import com.example.car_management.entity.Car;
import com.example.car_management.repository.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    // Save a car (new or updated)
    public Car saveCar(Car car) {
        return carRepository.save(car); // Spring Data JPA will handle saving/updating
    }

    // Search cars by name, model, or year
    public List<Car> searchCars(String name, String model, Integer year) {
        if (name != null && model != null && year != null) {
            return carRepository.findByNameContainingAndModelContainingAndYear(name, model, year);
        }
        if (name != null && model != null) {
            return carRepository.findByNameContainingAndModelContaining(name, model);
        }
        if (name != null) {
            return carRepository.findByNameContaining(name);
        }
        if (model != null) {
            return carRepository.findByModelContaining(model);
        }
        if (year != null) {
            return carRepository.findByYear(year);
        }
        return carRepository.findAll(); // If no filters, return all cars
    }

    // Handle pagination and sorting
    public Page<Car> getAllCars(int page, int size, String[] sort) {
        Sort.Order sortOrder = sort[1].equalsIgnoreCase("asc") ? Sort.Order.asc(sort[0]) : Sort.Order.desc(sort[0]);
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortOrder));
        return carRepository.findAll(pageable);
    }
}
