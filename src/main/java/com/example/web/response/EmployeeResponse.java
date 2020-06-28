package com.example.web.response;

import com.example.persistence.entity.Employee;

import java.time.LocalDate;

public class EmployeeResponse {
    private Integer id;
    private String name;
    private LocalDate  joinedDate;
    private DepartmentResponse departmentResponse;

    public EmployeeResponse(Employee employee){
        this.id = employee.getId();
        this.name = employee.getName();
        this.joinedDate = employee.getJoinedDate();
        this.departmentResponse = new DepartmentResponse(
                employee.getDepartmentId(),
                employee.getDepartmentName());
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getJoinedDate() {
        return joinedDate;
    }

    public DepartmentResponse getDepartmentResponse() {
        return departmentResponse;
    }
}
