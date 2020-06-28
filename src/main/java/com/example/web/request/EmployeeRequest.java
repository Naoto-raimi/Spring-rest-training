package com.example.web.request;

import com.example.persistence.entity.Employee;
import com.example.web.response.DepartmentResponse;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.time.LocalDate;

public class EmployeeRequest {
    private String name;
    private LocalDate joinedDate;
    private DepartmentRequest departmentRequest;

    @JsonCreator
    public EmployeeRequest(String name, LocalDate joinedDate, DepartmentRequest departmentRequest) {
        this.name = name;
        this.joinedDate = joinedDate;
        this.departmentRequest = departmentRequest;
    }

    public Employee convertToEntity() {
        return new Employee(name, joinedDate, departmentRequest.getId());
    }
}
