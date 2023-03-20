package com.java.blogposts.controller;

import com.java.blogposts.model.Category;
import com.java.blogposts.model.Post;
import com.java.blogposts.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@Slf4j
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/get-all-category")
    public List<Category> getCategories(){
       return categoryService.getAllCategory();
    }
    @GetMapping("/get/post/category/{id}")
    public Set<Post> getPostByCategoryId(@PathVariable Integer id){
        Optional<Category> category = categoryService.getPostByCategoryId(id);
        return category.get().getPosts();
    }
}
