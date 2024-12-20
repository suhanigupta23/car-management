package com.example.car_management.repository;

import com.example.car_management.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    // Search by name, model, and year
    List<Car> findByNameContainingAndModelContainingAndYear(String name, String model, Integer year);

    // Search by name and model
    List<Car> findByNameContainingAndModelContaining(String name, String model);

    // Search by name only
    List<Car> findByNameContaining(String name);

    // Search by model only
    List<Car> findByModelContaining(String model);

    // Search by year only
    List<Car> findByYear(Integer year);
}

