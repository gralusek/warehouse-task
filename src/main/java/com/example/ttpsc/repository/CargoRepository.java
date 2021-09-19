package com.example.ttpsc.repository;

import com.example.ttpsc.domain.Cargo;
import com.example.ttpsc.domain.CargoCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class CargoRepository {

    @Autowired
    WarehouseRepository warehouseRepository;

    private final static Map<Integer, Cargo> cargoMap = new HashMap<>();

    public Optional<Cargo> findById(Long id) {
        return Optional.ofNullable(cargoMap.get(id));
    }

    public void save(Cargo cargo) {
        cargoMap.put(cargo.getId(), cargo);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Development\\Projects\\TTPSC\\src\\main\\resources\\warehouse.csv"))) {

            writer.append("\n");
            writer.write(cargo.toString());
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Cargo> listCargoFromWarehouse(Long warehouseId) {
        return cargoMap.values().stream()
                .filter(c -> c.getWarehouseId() == warehouseId)
                .collect(Collectors.toList());
    }

    public int countWeightInWarehouse(Long warehouseId) {
        return cargoMap.values().stream()
                .map( c -> c.getMass() * c.getQuantity())
                .reduce(0, Integer::sum);
    }

    public void deleteCargo(Long id) {
        cargoMap.remove(findById(id));
    }

    public Collection<Cargo> findAll() {
        return cargoMap.values();
    }

    public List<Cargo> findByWarehouseId(int id) {
        return cargoMap
                .values()
                .stream()
                .filter(c -> c.getWarehouseId() == id)
                .collect(Collectors.toList());
    }

    public String displayDetails(Long id) {

        return findById(id)
                .map(desc -> desc.getDescription())
                .orElseThrow(() -> new RuntimeException("Cargo with given id was not found"));
    }


    public List<Cargo> cargoWithCategory(int warehouseId, CargoCat category) {

        return  findByWarehouseId(warehouseId)
                .stream()
                .filter(c -> c.getCategory().equals(category))
                .collect(Collectors.toList());
    }
}
