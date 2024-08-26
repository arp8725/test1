package com.kpit2.Springbootdemo.service;

import java.util.List;

import com.kpit2.Springbootdemo.entity.Department;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentByID(long departmentId);

    public void deleteDepartmentById(long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);

}
