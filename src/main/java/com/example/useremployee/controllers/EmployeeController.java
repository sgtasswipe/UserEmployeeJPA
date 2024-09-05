package com.example.useremployee.controllers;

import com.example.useremployee.model.Employee;
import com.example.useremployee.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
@Autowired
    EmployeeRepository employeeRepository;
    @GetMapping("/employee")
    public List<Employee> getEmployee() {
            return employeeRepository.findAll();

    }
@PostMapping ("/employee")
@ResponseStatus(HttpStatus.CREATED)
    public Employee postEmployee (@RequestBody Employee employee){
        System.out.println(employee);
        return employeeRepository.save(employee);
    }

    @PutMapping("/employee")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Employee> putEmployee (@RequestBody Employee employee) {
        Optional<Employee> std = employeeRepository.findById(employee.getId());
        if (std.isPresent()) {
            System.out.println(employee);
            employeeRepository.save(employee);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        Optional<Employee> std = employeeRepository.findById(id);
        if (std.isPresent()) {

            employeeRepository.deleteById(id);
            return ResponseEntity.ok("Employee deleted");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not deleted");
        }
    }
}

