package com.kpit.carmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kpit.carmanagement.entity.Car;
 
@Repository
public interface CarRepo extends JpaRepository<Car,Long>
{

}
