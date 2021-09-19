package com.example.ttpsc.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Cargo {

    private Integer id;

    private CargoCat category;

    private String description;

    private Integer mass;

    private Integer quantity;

    private Long warehouseId;

    private LocalDate dateOfArrival;

    public Cargo(String[] params) {
        this.id = Integer.valueOf(params[0]);
        this.category = CargoCat.valueOf(params[1]);
        this.description = String.valueOf(params[2]);
        this.mass = Integer.valueOf(params[3]);
        this.quantity = Integer.valueOf(params[4]);
        this.warehouseId = Long.parseLong(params[5]);
        this.dateOfArrival = LocalDate.parse(params[6]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cargo cargo = (Cargo) o;

        if (!id.equals(cargo.id)) return false;
        if (category != cargo.category) return false;
        if (description != null ? !description.equals(cargo.description) : cargo.description != null) return false;
        if (mass != null ? !mass.equals(cargo.mass) : cargo.mass != null) return false;
        if (quantity != null ? !quantity.equals(cargo.quantity) : cargo.quantity != null) return false;
        if (warehouseId != null ? !warehouseId.equals(cargo.warehouseId) : cargo.warehouseId != null) return false;
        return dateOfArrival != null ? dateOfArrival.equals(cargo.dateOfArrival) : cargo.dateOfArrival == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (mass != null ? mass.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (warehouseId != null ? warehouseId.hashCode() : 0);
        result = 31 * result + (dateOfArrival != null ? dateOfArrival.hashCode() : 0);
        return result;
    }
}
