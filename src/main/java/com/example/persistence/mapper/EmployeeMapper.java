package com.example.persistence.mapper;

import com.example.persistence.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    @Select("SELECT e.id AS id, e.name AS name, e.joined_date AS joined_date," +
            " d.id AS department_id, d.name AS department_name" +
            " FROM employee e" +
            " JOIN department d ON e.department_id = d.id" +
            " ORDER BY e.id")
    List<Employee> findAll();

    @Select("SELECT e.id AS id, e.name AS name, e.joined_date AS joined_date," +
            " d.id AS department_id, d.name AS department_name" +
            " FROM employee e" +
            " JOIN department d ON e.department_id = d.id" +
            " WHERE e.name LIKE #{keyword}" +
            " ORDER BY e.id")
    List<Employee> findByNameLike(String keyword);

    @Insert("INSERT INTO employee(name, joined_date, department_id)" +
            " VALUES(#{name}, #{joinedDate}, #{departmentId})")
    void insert(Employee employee);


}
