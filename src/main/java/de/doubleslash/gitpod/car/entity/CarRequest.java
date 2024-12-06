package de.doubleslash.gitpod.car.entity;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CarRequest {
    @NotNull
    private String model;

    @NotNull
    private String brand;

    private Instant date;

    public CarRequest(String model, String brand) {
        this.model = model;
        this.brand = brand;
    }
}

