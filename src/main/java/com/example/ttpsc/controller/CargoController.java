package com.example.ttpsc.controller;

import com.example.ttpsc.domain.Cargo;
import com.example.ttpsc.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cargo")
public class CargoController {

    @Autowired
    CargoRepository cargoRepository;

    @GetMapping
    public String getDescription(Long cargoId) {
        return cargoRepository.displayDetails(cargoId);
    }


}
