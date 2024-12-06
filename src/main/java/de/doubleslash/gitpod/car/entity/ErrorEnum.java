package de.doubleslash.gitpod.car.entity;

import lombok.Getter;

@Getter
public enum ErrorEnum {
    CAR_NOT_FOUND(1001);

    private final long id;

    ErrorEnum(long id) {
        this.id = id;
    }
}
