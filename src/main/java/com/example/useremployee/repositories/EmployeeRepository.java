package com.example.useremployee.repositories;

import com.example.useremployee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    List<Employee> findByName(String name);
    void deleteEmployeeById(int id);

}
