package com.example.useremployee.config;

import com.example.useremployee.model.Employee;
import com.example.useremployee.model.Gender;
import com.example.useremployee.model.User;
import com.example.useremployee.repositories.EmployeeRepository;
import com.example.useremployee.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class InitData implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {

        if (userRepository.findAll().isEmpty()) {
            User usr1 = new User();
            usr1.setEmail("otto@gmail.com");
            usr1.setPassword("jpa");
            userRepository.save(usr1);
            usr1.setUserID(0);
            usr1.setEmail("kurt@yahoo.com");
            usr1.setPassword("apj");
            userRepository.save(usr1);
            Employee emp2 = new Employee();
            emp2.setBornDate(LocalDate.of(1995, 2, 2));
            emp2.setName("Wayne");
            emp2.setGender(Gender.MALE);
            emp2.setUser(usr1);
            employeeRepository.save(emp2);

            usr1.setUserID(0);

            usr1.setEmail("Bent@outlook.com");
            usr1.setPassword("john");
            userRepository.save(usr1);

            Employee emp1 = new Employee();
            emp1.setBornDate(LocalDate.of(1990, 1, 1));
            emp1.setName("Bruce");
            emp1.setGender(Gender.MALE);
            emp1.setUser(usr1);
            employeeRepository.save(emp1);


        }
    }
}
