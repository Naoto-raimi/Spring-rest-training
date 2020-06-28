package com.example.service.impl;

import com.example.persistence.entity.Employee;
import com.example.persistence.mapper.EmployeeMapper;
import com.example.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = employeeMapper.findAll();
        return employeeList;
    }

    @Override
    public Employee findById(Integer id) {
        Employee employee = employeeMapper.findById(id);
        return employee;
    }

//    @Override
//    public void insert(Employee employee) {
//        employeeMapper.insert(employee);
//    }
//
//    @Override
//    public void update(Employee employee) {
//        employeeMapper.update(employee);
//    }
//
//    @Override
//    public void delete(Integer id) {
//        employeeMapper.delete(id);
//    }
//
//    @Override
//    public boolean exists(Integer id) {
//        int count = employeeMapper.countById(id);
//        return count == 1;
//    }
}
