package com.java.blogposts.controller;

import com.java.blogposts.model.Post;
import com.java.blogposts.repository.PostCategoryRepository;
import com.java.blogposts.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PostController {

//    @Autowired
//    private PostCategoryRepository postCategoryRepository;
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/get-post/{id}")
    public Post getPost(@PathVariable long id){
        System.out.println(id);
        return postRepository.findById(1);
    }
}
