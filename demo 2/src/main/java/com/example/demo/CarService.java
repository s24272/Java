package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {

    CarRepository carRepository ;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
        carRepository.save(new Car("honda", "gda2672"));
        carRepository.save(new Car("BMW", "S7EF"));
    }

    public Optional<Car> findById(Long id){
        return carRepository.findById(id);
    }
    public Car findByMake(String make){
        return carRepository.findByMake(make);
    }

    public void save(Car car){
        carRepository.save(car);
    }

    public void delete(Car car) { carRepository.delete(car);}
}
