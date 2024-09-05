package com.example.useremployee.controllers;

import com.example.useremployee.model.User;
import com.example.useremployee.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RestUserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user")
    public List<User> getUsers() {
        return userRepository.findAll();

    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User postUser(@RequestBody User user) {
        System.out.println(user);
        return userRepository.save(user);


    }

    @PutMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> putUser(@RequestBody User user) { //
        Optional<User> std = userRepository.findById(user.getUserID());  // optional er wrapper klasse. uanset om den findes eller ej får vi samme objekt tilbage
        if (std.isPresent()) {
            System.out.println(user);
            userRepository.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // returnerer en tom body
        }


    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> delteUser(@PathVariable int id) {
        Optional<User> std = userRepository.findById(id);
        if (std.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.ok("User deleted");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not deleted");  // returnerer en tom body
        }
    }
}
