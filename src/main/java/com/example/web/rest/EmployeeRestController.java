package com.example.web.rest;

import com.example.persistence.entity.Employee;
import com.example.service.EmployeeService;
import com.example.web.request.EmployeeRequest;
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
    public List<EmployeeResponse> findAll(){
        List<Employee> employeeList = employeeService.findAll();
        List<EmployeeResponse> employeeResponseList = new ArrayList<>();
        for(Employee employee : employeeList){
            EmployeeResponse employeeResponse = new EmployeeResponse(employee);
            employeeResponseList.add(employeeResponse);
        }
        return employeeResponseList;
    }

    @GetMapping("/{id}")
    public EmployeeResponse findById(@PathVariable Integer id){
        Employee employee = employeeService.findById(id);
        EmployeeResponse employeeResponse = new EmployeeResponse(employee);
        return employeeResponse;
    }

    @PostMapping
    public ResponseEntity insert(@RequestBody EmployeeRequest employeeRequest) {
        // EmployeeRequestをEmployeeに変換
        Employee employee = employeeRequest.convertToEntity();
        // DBに追加
        employeeService.insert(employee);
        // 追加した社員を表すURLを作成
        URI location = ServletUriComponentsBuilder.fromCurrentRequest() // http://localhost:8080/employees
                .pathSegment(employee.getId().toString()) // http://localhost:8080/employees/新しい社員ID
                .build().encode().toUri();
        // 201 Createdでレスポンス
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id,
                                 @RequestBody EmployeeRequest employeeRequest) {
        // EmployeeRequestをEmployeeに変換
        Employee employee = employeeRequest.convertToEntity();
        // EmployeeRequestにはidが含まれていないので、idをセット
        employee.setId(id);
        // DBを更新
        employeeService.update(employee);
        // 200 OKでレスポンス
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        // DBから削除
        employeeService.delete(id);
        // 204 No Contentでレスポンス
        return ResponseEntity.noContent().build();
    }
}
