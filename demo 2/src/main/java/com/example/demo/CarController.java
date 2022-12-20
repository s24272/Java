package com.example.demo;

import com.example.demo.exeptions.CarNotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;


@RestController
public class CarController {

    CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Car>> findById(@PathVariable("id") Long id){

        if(carService.findById(id).isPresent()) {
            return new ResponseEntity<>(carService.findById(id), HttpStatus.MULTI_STATUS);
        } else {
            CarNotFoundExeption carNotFoundExeption = new CarNotFoundExeption("Car id not found");
            throw carNotFoundExeption;
        }
    }
    @GetMapping("/make/{make}")
    public ResponseEntity<Car> findByMake(@PathVariable("make") String make){
        if(carService.findByMake(make) == null){
            CarNotFoundExeption carNotFoundExeption = new CarNotFoundExeption("Car make not found");
            throw carNotFoundExeption;
        }
        return new ResponseEntity<Car>(carService.findByMake(make), HttpStatus.MULTI_STATUS);
    }

    @PostMapping("car/add")
    public void postCar(@RequestBody Car car){
        carService.save(car);
    }

    @DeleteMapping("delete/{id}")
    public void deleteCar(@PathVariable("id") Long id){
        carService.delete(carService.findById(id).get());
    }


}
