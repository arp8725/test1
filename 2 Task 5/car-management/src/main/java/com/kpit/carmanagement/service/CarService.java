package com.kpit.carmanagement.service;


import java.util.Optional;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpit.carmanagement.entity.Car;
import com.kpit.carmanagement.repository.CarRepo;

@Service
public class CarService  
{
    @Autowired
    private CarRepo cr;

    public Car saveCar(Car car)
    {
        return cr.save(car);
    }

    public Optional<Car> getCarById(Long id)
    {
        return cr.findById(id);
    }

    public List<Car> getAllCars()
    {
        return cr.findAll();
    }

    public void deleteCarById(Long id)
    {
        cr.deleteById(id);
    }

    public List<Car>getCarsSortedByPriceDesc(int n)
    {
        return cr.findAll()
        .stream().sorted((car1,car2)->car2.getPrice()
        .compareTo(car1.getPrice()))
        .limit(n).toList();
    }


 @Autowired
    private CarRepo repo;
 
        public void loadData() throws CsvValidationException, NumberFormatException{
            String csvFilePath = "C:\\Users\\adityap16\\Desktop\\Task 5\\car-management\\src\\main\\resources\\CAR_DETAILS_DATA.csv";
            try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
               String[] nextLine;
               reader.readNext(); // Skip header line
    
               while ((nextLine = reader.readNext()) != null) {
                   Car car = new Car();
                   
                   car.setModelName(nextLine[0]);
                   car.setYear(nextLine[1]);
                   car.setPrice(Double.parseDouble(nextLine[2]));
                   car.setDistance(Double.parseDouble(nextLine[3]));
                   car.setEngineType(nextLine[4]);
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
