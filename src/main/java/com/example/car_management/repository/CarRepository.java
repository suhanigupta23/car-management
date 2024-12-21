package com.example.car_management.repository;

import com.example.car_management.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    // Pagination and Sorting: Finds all cars with pagination and sorting
    Page<Car> findAll(Pageable pageable);

    // Global Search: Finds cars by name, model, color, or fuel type (ignoring case)
    List<Car> findByCarNameContainingIgnoreCaseOrModelContainingIgnoreCaseOrColorContainingIgnoreCaseOrFuelTypeContainingIgnoreCase(
            String carName, String model, String color, String fuelType);
}
