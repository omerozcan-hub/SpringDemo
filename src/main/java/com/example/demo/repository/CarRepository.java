package com.example.demo.repository;
import com.example.demo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{
    Optional<Car> findOneByName(String name);

    void deleteById(Integer id);
    List<Car> findByProductionDate(LocalDate date);

    List<Car> findByProductionDateAfter(LocalDate date);

    List<Car> findByProductionDateBefore(LocalDate date);
}
