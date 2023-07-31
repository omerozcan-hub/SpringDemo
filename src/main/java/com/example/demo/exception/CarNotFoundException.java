package com.example.demo.exception;

public class CarNotFoundException extends RuntimeException{
    public CarNotFoundException(String msg){
        super(msg);
    }
}
