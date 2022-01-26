package com.codeclan.example.WhiskyLab.WhiskyLab.controllers;

import com.codeclan.example.WhiskyLab.WhiskyLab.models.Distillery;
import com.codeclan.example.WhiskyLab.WhiskyLab.models.Whisky;
import com.codeclan.example.WhiskyLab.WhiskyLab.repositories.WhiskyRepository;
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
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getWhiskies(){
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/{id}")
    public ResponseEntity<Optional<Whisky>> getDistilleryById(@PathVariable Long id) {
        return new ResponseEntity<>(whiskyRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/getbyyear")
    public ResponseEntity<List<Whisky>> getByYear(@RequestParam int year) {
        return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/getbydistilleryandage")
    public ResponseEntity<List<Whisky>> getByDistilleryAndAge(@RequestParam(name = "age") int age,
                                                              @RequestParam(name = "distillery") String distilleryname){
        return new ResponseEntity<>(whiskyRepository.findByAgeAndDistilleryName(age, distilleryname), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/byregion")
    public ResponseEntity<List<Whisky>> getByRegion(@RequestParam(name = "region") String region){
        return new ResponseEntity<>(whiskyRepository.findByDistilleryRegion(region), HttpStatus.OK);
    }
}
