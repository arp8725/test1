package com.example.demo.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Car;
import com.example.demo.repo.CarRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

@Service
public class CarService {
    
    @Autowired
    private CarRepository carRepository;
    public Car saveCar(Car car){
        return carRepository.save(car);
    }

    public java.util.Optional<Car> getCarByID(Long id){
     return carRepository.findById(id);
    }

    public List<Car> getALLCars(){
        return carRepository.findAll();
        
    }

    public void deleteCarById(Long id){
        carRepository.deleteById(id);
    }

 

    public List<Car> getCarsSortedBYPriceDecs(int n){
        return carRepository.findAll().stream().
        sorted((car1,car2)->car2.getPrice().compareTo(car1.getPrice())).limit(n).toList();
    }

    // @Autowired
    // private CarService carService;
    @Autowired
    private CarRepository repo;
 
        public void loadData() throws CsvValidationException, NumberFormatException{
            String csvFilePath = "C:\\Users\\shubhamk21\\Desktop\\GenesisPro\\new\\cardetails\\src\\main\\resources\\CAR_DETAILS_DATA.csv";
            try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
               String[] nextLine;
               reader.readNext(); // Skip header line
    
               while ((nextLine = reader.readNext()) != null) {
                   Car car = new Car();
                   
                   car.setModelName(nextLine[0]);
                   car.setYear(nextLine[1]);
                   car.setPrice(Double.parseDouble(nextLine[2]));
                   car.setDistance(Double.parseDouble(nextLine[3]));
                   car.setFuleType(nextLine[4]);
                   car.setSellerType(nextLine[5]);
                   car.setTransmission(nextLine[6]);
                   car.setOwner(nextLine[7]);
    
                   repo.save(car);
                   System.out.println("Data Loaded Succesfully...");
               }
           } catch (IOException e) {
               e.printStackTrace();
           }
        }
        
    

}
