package com.example.ttpsc.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Warehouse {

    private Integer id;

    private String location;

    private int maxCapacity;

    public Warehouse(String[] params) {
        this.id = Integer.valueOf(params[0]);
        this.location = String.valueOf(params[1]);
        this.maxCapacity = Integer.parseInt(params[2]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Warehouse warehouse = (Warehouse) o;

        if (maxCapacity != warehouse.maxCapacity) return false;
        if (!id.equals(warehouse.id)) return false;
        return location.equals(warehouse.location);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + location.hashCode();
        result = 31 * result + maxCapacity;
        return result;
    }


}
