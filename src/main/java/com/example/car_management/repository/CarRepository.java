package com.example.car_management.repository;

import com.example.car_management.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT c FROM Car c WHERE " +
       "(:name IS NULL OR c.name LIKE %:name%) AND " +
       "(:model IS NULL OR c.model LIKE %:model%) AND " +
       "(:year IS NULL OR c.year = :year)")
List<Car> searchCars(String name, String model, Integer year);

}

