package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Car {
	
	@Id
   @GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;
    private String modelName;
    private String year;
    private Double price;
    private Double distance;
    private String fuleType;
    private String sellerType;
    private String transmission;
    private String owner;

}
