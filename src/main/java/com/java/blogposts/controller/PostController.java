package com.java.blogposts.controller;

import com.java.blogposts.model.Post;
import com.java.blogposts.model.User;
import com.java.blogposts.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PostController {

//    @Autowired
//    private PostCategoryRepository postCategoryRepository;
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/get-post/{id}")
    public Optional<Post> getPost(@PathVariable Integer id){
        return postRepository.findById(id);
    }

    @GetMapping("/get-all-posts")
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }
}
