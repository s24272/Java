package com.example.demo.exeptions;

public class CarNotFoundExeption extends RuntimeException{

    public CarNotFoundExeption(String message) {
        super(message);
    }
}
