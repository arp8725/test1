package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.CarService;
import com.opencsv.exceptions.CsvValidationException;

@SpringBootTest
class CardetailsApplicationTests {

	@Autowired
	CarService car;
	// @Test
	// void contextLoads() throws CsvValidationException, NumberFormatException {
	// 	car.loadData();
		
	// }

	
	@Test
	void contextLoads()  {
		car.getALLCars();
		
	}

}
