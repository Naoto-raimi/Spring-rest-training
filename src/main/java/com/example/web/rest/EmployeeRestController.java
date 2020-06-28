package com.example.web.rest;

import com.example.persistence.entity.Employee;
import com.example.service.EmployeeService;
import com.example.web.response.EmployeeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeResponse> findAll() {
        // 検索
        List<Employee> employeeList = employeeService.findAll();
        // EmployeeResponseのリストに変換
        List<EmployeeResponse> employeeResponseList = new ArrayList<>();
        for (Employee employee : employeeList) {
            EmployeeResponse employeeResponse = new EmployeeResponse(employee);
            employeeResponseList.add(employeeResponse);
        }
        // 戻り値がJSONに変換される
        return employeeResponseList;
    }

    @GetMapping("/{id}")
    public EmployeeResponse findById(@PathVariable Integer id) {
        // 検索
        Employee employee = employeeService.findById(id);
        // EmployeeResponseに変換
        EmployeeResponse employeeResponse = new EmployeeResponse(employee);
        // 戻り値がJSONに変換される
        return employeeResponse;
    }
}
