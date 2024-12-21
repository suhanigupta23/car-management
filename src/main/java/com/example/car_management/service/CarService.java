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
        return carRepository.searchCars(
            name != null ? name : "",
            model != null ? model : "",
            year
        );
    }
    
    // Handle pagination and sorting
    public Page<Car> getAllCars(int page, int size, String[] sort) {
        if (page < 0 || size <= 0) {
            throw new IllegalArgumentException("Page index must be >= 0 and size > 0");
        }
        
        // Default sorting fallback if 'sort' is not provided
        if (sort == null || sort.length == 0) {
            sort = new String[]{"id", "asc"}; // Default to sort by 'id' ascending
        }
    
        // Handle sorting logic
        Sort sortOrder = Sort.by(
            sort.length > 1 && sort[1].equalsIgnoreCase("desc")
                ? Sort.Order.desc(sort[0])
                : Sort.Order.asc(sort[0])
        );
    
        Pageable pageable = PageRequest.of(page, size, sortOrder);
        return carRepository.findAll(pageable);
    }
      
}
