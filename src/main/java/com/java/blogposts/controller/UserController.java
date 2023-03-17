package com.java.blogposts.controller;

import com.java.blogposts.Repository.UserRepository;
import com.java.blogposts.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/get-all-users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
