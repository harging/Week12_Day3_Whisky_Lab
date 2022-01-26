package com.codeclan.example.WhiskyLab.WhiskyLab.repositories;

import com.codeclan.example.WhiskyLab.WhiskyLab.models.Distillery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistilleryRepository extends JpaRepository<Distillery, Long> {

    List<Distillery> findDistilleriesByRegion(String region);
    List<Distillery> findByWhiskiesAge(int age);
}
