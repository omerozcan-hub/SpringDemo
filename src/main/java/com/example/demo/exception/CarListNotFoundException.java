package com.example.demo.exception;

public class CarListNotFoundException extends RuntimeException {
    public CarListNotFoundException(String carListIsEmpty) {
        super(carListIsEmpty);
    }
}
