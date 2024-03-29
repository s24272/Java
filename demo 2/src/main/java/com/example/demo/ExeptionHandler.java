package com.example.demo;

import com.example.demo.exeptions.CarNotFoundExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExeptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { CarNotFoundExeption.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);}
}


