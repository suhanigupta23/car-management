package com.example.car_management.repository;

import com.example.car_management.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    // Global Search: Finds cars by name, model, color, or fuel type (ignoring case)
    List<Car> findByCarNameContainingIgnoreCaseOrModelContainingIgnoreCaseOrColorContainingIgnoreCaseOrFuelTypeContainingIgnoreCase(
            String carName, String model, String color, String fuelType);

    // Global Search with Pagination
    Page<Car> findByCarNameContainingIgnoreCaseOrModelContainingIgnoreCaseOrColorContainingIgnoreCaseOrFuelTypeContainingIgnoreCase(
            String carName, String model, String color, String fuelType, Pageable pageable);

    // Global Search with Sorting
    List<Car> findByCarNameContainingIgnoreCaseOrModelContainingIgnoreCaseOrColorContainingIgnoreCaseOrFuelTypeContainingIgnoreCase(
            String carName, String model, String color, String fuelType, Sort sort);
}
