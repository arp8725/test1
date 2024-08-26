package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Car;
import com.example.demo.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        return carService.getCarByID(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCarById(@PathVariable Long id, @RequestBody Car updatedCar) {
        return carService.getCarByID(id)
                .map(car -> {
                
                    car.setModelName(updatedCar.getModelName());
                    car.setYear(updatedCar.getYear());
                    car.setPrice(updatedCar.getPrice());
                    car.setDistance(updatedCar.getDistance());
                    car.setFuleType(updatedCar.getFuleType());
                    car.setSellerType(updatedCar.getSellerType());
                    car.setTransmission(updatedCar.getTransmission());
                    car.setOwner(updatedCar.getOwner());
        
                    carService.saveCar(car);
                    return ResponseEntity.ok(car);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarById(@PathVariable Long id) {
        carService.deleteCarById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getALLCars();
    }

    @GetMapping("/top/{n}")
    public List<Car> getTopCarsByPrice(@PathVariable int n) {
        return carService.getCarsSortedBYPriceDecs(n);
    }
}
