package com.example.ttpsc.repository;

import com.example.ttpsc.domain.Cargo;
import com.example.ttpsc.domain.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class WarehouseRepository{

    @Autowired
    CargoRepository cargoRepository;

    private final Map<Integer, Warehouse> warehouseMap = new HashMap<>();

    public Optional<Warehouse> findById(Long id) {
        return Optional.ofNullable(warehouseMap.get(id));
    }

    public void save (Warehouse warehouse) {
        warehouseMap.put(warehouse.getId(), warehouse);
    }

    public Collection<Warehouse> findAll() {
        return warehouseMap.values();
    }

    public void addCargoToWarehouse(Long cargoId, Long warehouseId) {
        Optional<Cargo> cargo = cargoRepository.findById(cargoId);
        Optional<Warehouse> warehouse = findById(warehouseId);

        cargo.ifPresent(c -> c.setWarehouseId(warehouseId));
    }

    public void deleteCargoFromWarehouse(Long cargoId, Long warehouseId) {
        Optional<Cargo> cargo = cargoRepository.findById(cargoId);
        Optional<Warehouse> warehouse = findById(warehouseId);

        cargo.ifPresent(c -> c.setWarehouseId(null));
    }

    /*public List<Warehouse> ListWarehouseAlmostFull() {
        int warehousesize = warehouseMap.size();
        int capacity = cargoRepository.
        return findAll()
                .stream()
                .filter(wh -> wh.)
                .filter(wh -> wh.getActCapacity() / wh.getMaxCapacity() >= 0.8)
                .collect(Collectors.toList());
    }

    public List<Warehouse> ListWarehouseAlmostEmpty() {
        return warehouseRepository
                .findAll()
                .stream()
                .filter(wh -> wh.getActCapacity() / wh.getMaxCapacity() <= 0.2)
                .collect(Collectors.toList());
    }*/

/*    public void moveCargo (Long cargoId, Long whId) {
        Optional<Cargo> cargo = cargoRepository.findById(cargoId);
        Optional<Warehouse> wh1 = findById(whId);

        warehouseMap.values().stream()
                        .filter(c -> c.)
        cargo.ifPresent(c -> c.setWarehouseId(whId));


    }*/



}
