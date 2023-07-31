package com.example.demo.exception;

public class CarCouldNotDeleted extends RuntimeException {
    public CarCouldNotDeleted(String carCouldNotDeleted) {
        super(carCouldNotDeleted);
    }
}
