package com.java.blogposts.controller;

import com.java.blogposts.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return List.of();
    }

}
