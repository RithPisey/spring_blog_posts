package com.java.blogposts.controller;

import com.java.blogposts.repository.UserRepository;
import com.java.blogposts.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/get-all-users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/get-user/{id}")
    public Optional<User> getUserById(@PathVariable Integer id){
        return userRepository.findById(id);
    }

    @RequestMapping("/user")
    public User getUserDetailsAfterLogin(Principal user) {
        Optional<User> users = userRepository.findByEmail(user.getName());
        if (users.isPresent()) {
            return users.get();
        }else {
            return null;
        }

    }
}
