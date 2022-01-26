package com.codeclan.example.WhiskyLab.WhiskyLab.controllers;

import com.codeclan.example.WhiskyLab.WhiskyLab.models.Distillery;
import com.codeclan.example.WhiskyLab.WhiskyLab.models.Whisky;
import com.codeclan.example.WhiskyLab.WhiskyLab.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping(value = "/distilleries")
    public ResponseEntity<List<Distillery>> getDistilleries(){
        return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/distilleries/{id}")
    public ResponseEntity<Optional<Distillery>> getDistilleryById(@PathVariable Long id) {
        return new ResponseEntity<>(distilleryRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/distilleries/byregion")
    public ResponseEntity<List<Distillery>> findDistilleriesByRegion(@RequestParam String region){
        return new ResponseEntity<>(distilleryRepository.findDistilleriesByRegion(region), HttpStatus.OK);
    }

    @GetMapping(value = "/distilleries/twelve")
    public ResponseEntity<List<Distillery>> findDistilleriesByWhiskiesThatEqual12(){
        return new ResponseEntity<>(distilleryRepository.findByWhiskiesAge(12), HttpStatus.OK);
    }
}
