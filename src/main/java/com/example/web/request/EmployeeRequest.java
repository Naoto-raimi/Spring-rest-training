package com.example.web.request;

import com.example.persistence.entity.Employee;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.time.LocalDate;

public class EmployeeRequest {
    private String name;
    private LocalDate joinedDate;
    private DepartmentRequest department;

    @JsonCreator
    public EmployeeRequest(String name, LocalDate joinedDate, DepartmentRequest department){
        this.name = name;
        this.joinedDate = joinedDate;
        this.department = department;
    }

    public Employee convertToEntity(){
        return new Employee(name, joinedDate, department.getId());
    }

}
