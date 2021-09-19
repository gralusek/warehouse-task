package com.example.ttpsc.controller;

import com.example.ttpsc.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/warehouse")
public class WarehouseController {

    @Autowired
    WarehouseRepository warehouseRepository;

    @PutMapping(value = "addCargoToWarehouse")
    public void addCargoToWarehouse(Long cargoId, Long warehouseId) {
        if(warehouseId > warehouseRepository.findAll().size()) {
            warehouseRepository.addCargoToWarehouse(cargoId, warehouseId);
        } else {
            throw new RuntimeException("Warehouse with given Id does not exist");
        }
    }

    @PutMapping(value = "removeCargoFromWarehouse")
    public void removeCargoFromWarehouse(Long cargoId, Long warehouseId) {
        warehouseRepository.deleteCargoFromWarehouse(cargoId,warehouseId);
    }
}
