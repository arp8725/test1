package com.kpit2.Springbootdemo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpit2.Springbootdemo.entity.Department;
import com.kpit2.Springbootdemo.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{


    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
        
    }
    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }
    @Override
    public Department fetchDepartmentByID(long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }
    @Override
    public void deleteDepartmentById(long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDB = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName()))
        {
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode()))
        {
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress()))
        {
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(depDB);

        
    }
    @Override
    public Department fetchDepartmentByName(String departmentName) {
        // return departmentRepository.findByDepartmentName(departmentName);
        
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

}
