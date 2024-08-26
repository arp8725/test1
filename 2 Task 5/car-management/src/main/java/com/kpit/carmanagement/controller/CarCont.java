package com.kpit.carmanagement.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kpit.carmanagement.entity.Car;
import com.kpit.carmanagement.service.CarService;

@RestController
@RequestMapping("/api/cars")
public class CarCont 
{
    @Autowired
    private CarService carService;

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id)
    {
        return carService.getCarById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCarById(@PathVariable Long id, @RequestBody Car updatedCar) {
        return carService.getCarById(id)
                .map(car -> {
                    car.setModelName(updatedCar.getModelName());
                    car.setYear(updatedCar.getYear());
                    car.setPrice(updatedCar.getPrice());
                    car.setDistance(updatedCar.getDistance());
                    car.setEngineType(updatedCar.getEngineType());
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
        return carService.getAllCars();
    }

    @GetMapping("/top")
    public List<Car> getTopCarsByPrice(@PathVariable int n) {
        return carService.getCarsSortedByPriceDesc(n);
    }

}
