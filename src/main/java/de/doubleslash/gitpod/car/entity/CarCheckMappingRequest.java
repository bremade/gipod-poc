package de.doubleslash.gitpod.car.entity;

import lombok.Builder;

public class CarCheckMappingRequest extends CarRequest {
    @Builder
    public CarCheckMappingRequest(String model, String brand) {
        super(model, brand);
    }


    public CarBE mapToCarEntity() {
        CarBE car = new CarBE();
        car.setBrand(super.getBrand());
        car.setModel(super.getModel());
        return car;
    }
}

