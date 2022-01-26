package com.codeclan.example.WhiskyLab.WhiskyLab.repositories;

import com.codeclan.example.WhiskyLab.WhiskyLab.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WhiskyRepository extends JpaRepository<Whisky, Long> {
    List<Whisky> findByYear(int year);
    List<Whisky> findByAgeAndDistilleryName(int age, String distilleryname);
    List<Whisky> findByDistilleryRegion(String region);
}
