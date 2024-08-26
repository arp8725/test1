package com.kpit2.Springbootdemo.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;


//this is the entity which we have created. to make this particular class as entitiy,so that i can interact with the datebase we need to annotate it with @Entitiy

@Entity
@Data
@NoArgsConstructor
public class Department 
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long departmentId;

    @NotBlank(message = "Please Add Department Name")
    // @Length(max=7,min=1)
    // @Size(max = 10,min = 1)
    // @Email
    // @Positive
    // @Negative 

    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
   
    // public long getDepartmentId() {
    //     return departmentId;
    // }
    // public void setDepartmentId(long departmentId) {
    //     this.departmentId = departmentId;
    // }
    // public String getDepartmentName() {
    //     return departmentName;
    // }
    // public void setDepartmentName(String departmentName) {
    //     this.departmentName = departmentName;
    // }
    // public String getDepartmentAddress() {
    //     return departmentAddress;
    // }
    // public void setDepartmentAddress(String departmentAddress) {
    //     this.departmentAddress = departmentAddress;
    // }
    // public String getDepartmentCode() {
    //     return departmentCode;
    // }
    // public void setDepartmentCode(String departmentCode) {
    //     this.departmentCode = departmentCode;
    // }
    // public Department(long departmentId, String departmentName, String departmentAddress, String departmentCode) {
    //     this.departmentId = departmentId;
    //     this.departmentName = departmentName;
    //     this.departmentAddress = departmentAddress;
    //     this.departmentCode = departmentCode;
    // }

    // public Department() //------> default constructor
    // {

    // }
    // @Override
    // public String toString() {
    //     return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName
    //             + ", departmentAddress=" + departmentAddress + ", departmentCode=" + departmentCode + "]";
    // }

    

}
