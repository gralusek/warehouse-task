package com.example.ttpsc;

import com.example.ttpsc.domain.Cargo;
import com.example.ttpsc.domain.Warehouse;
import com.example.ttpsc.repository.CargoRepository;
import com.example.ttpsc.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TtpscApplication {

    private static final String COMMA_DELIMITER = ",";

    @Autowired
    CargoRepository cargoRepository;

    @Autowired
    WarehouseRepository warehouseRepository;

    @PostConstruct
    public void loadData(){

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Development\\Projects\\TTPSC\\src\\main\\resources\\Cargo.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] cargo = line.split(COMMA_DELIMITER);
                cargoRepository.save(new Cargo(cargo));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Development\\Projects\\TTPSC\\src\\main\\resources\\warehouse.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] warehouse = line.split(COMMA_DELIMITER);
                warehouseRepository.save(new Warehouse(warehouse));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        cargoRepository.findAll().forEach(System.out::println);


    }

    public static void main(String[] args) {
        SpringApplication.run(TtpscApplication.class, args);
    }

}
