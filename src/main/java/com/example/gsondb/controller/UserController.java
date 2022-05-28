package com.example.gsondb.controller;

import com.example.gsondb.exception.ResourceNotFoundException;
import com.example.gsondb.model.User;
import com.example.gsondb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {
//Creating Spring Boot CRUD REST APIs
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    //build creat user rest API
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
        return ResponseEntity.ok(user);
    }

    // build update employee REST API
    @PutMapping ("{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User userDetails){
        User updateUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
        updateUser.setFirstName(userDetails.getFirstName());
        updateUser.setLastName(userDetails.getLastName());
        updateUser.setEmail(userDetails.getEmail());
        updateUser.setPassword(userDetails.getPassword());

        userRepository.save(updateUser);

        return ResponseEntity.ok(updateUser);
    }

    // build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
        userRepository.delete(user);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
