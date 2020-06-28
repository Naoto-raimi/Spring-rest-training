package com.example.service.impl;

import com.example.persistence.entity.Employee;
import com.example.persistence.mapper.EmployeeMapper;
import com.example.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        List<Employee> employeeList = employeeMapper.findAll();
        return employeeList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findByNameLike(String keyword) {
        List<Employee> employeeList = employeeMapper.findByNameLike("%" + keyword + "%");
        return employeeList;
    }

    @Override
    @Transactional(readOnly = false)
    public void insert(Employee employee) {
        employeeMapper.insert(employee);
    }
}
