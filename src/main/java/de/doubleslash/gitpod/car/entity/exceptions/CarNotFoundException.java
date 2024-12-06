package de.doubleslash.gitpod.car.entity.exceptions;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(long id) {
        super("Car with ID: " + id + " not found!");
    }

    public CarNotFoundException() {
        super("No cars found!");
    }
}