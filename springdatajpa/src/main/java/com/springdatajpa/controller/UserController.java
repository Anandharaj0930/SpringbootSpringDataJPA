package com.springdatajpa.controller;

import com.springdatajpa.entity.User;
import com.springdatajpa.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    IUserRepository userRepository;

    @GetMapping(value = "/getAll", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public List<User> getAllusers() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/getAll/{name}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User getUserByName(@PathVariable("name") String name) {
        return userRepository.getByName(name);
    }

    @PostMapping(value = "/load", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User getUserByName(@RequestBody User user) {
        userRepository.save(user);
        return userRepository.getByName(user.getName());
    }

    @Autowired
    public void setUserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
