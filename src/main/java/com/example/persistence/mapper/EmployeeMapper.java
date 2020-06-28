package com.example.persistence.mapper;

import com.example.persistence.entity.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
            " WHERE e.id = #{id}")
    Employee findById(Integer id);

    @Insert("INSERT INTO employee(name, joined_date, department_id)" +
            " VALUES(#{name}, #{joinedDate}, #{departmentId})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(Employee employee);

    @Update("UPDATE employee" +
            " SET name = #{name}, joined_date = #{joinedDate}, department_id = #{departmentId}" +
            " WHERE id = #{id}")
    void update(Employee employee);

    @Delete("DELETE FROM employee WHERE id = #{id}")
    void delete(Integer id);

    @Select("SELECT COUNT(*) FROM employee WHERE id = #{id}")
    int countById(Integer id);
}
