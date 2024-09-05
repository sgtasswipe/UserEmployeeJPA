package com.example.useremployee.repositories;

import com.example.useremployee.model.Employee;
import com.example.useremployee.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    UserRepository userRepository;

    @Test
     void testOneBruce() {
        List<Employee> lst  = employeeRepository.findByName("Bruce");
        assertEquals(1, lst.size());
    }

   @Test
    void deleteOneEmployee () {
        List<Employee> lst = employeeRepository.findByName("Bruce");
        Employee emp1 = lst.get(0);
     //   userRepository.delete(emp1.getUser());   kaster en exeption og derfor laves der en asserthrows
        assertThrows(Exception.class, () -> userRepository.delete(emp1.getUser()));
        // efter vi har sat cascade på i user kaster den ikke en exeption da den nu godt kan slettes.
   }

   @Test
    void createOneUser() {
        User usr = new User();
        usr.setEmail("kurtbent@gmail.com");
        usr.setPassword("jpa");
        userRepository.save(usr);
        // assertEquals("jpa", usr.getPassword());
        assertEquals(1, userRepository.findAllByEmail("kurtbent@gmail.com").size());
   }
}