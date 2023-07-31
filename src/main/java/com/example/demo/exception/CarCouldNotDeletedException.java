package com.example.demo.exception;


public class CarCouldNotDeletedException extends RuntimeException {
    public CarCouldNotDeletedException(String s) {
        super(s);
    }
}
