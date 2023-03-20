package com.java.blogposts.service;

import com.java.blogposts.model.Category;
import com.java.blogposts.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService
{
    @Autowired
    private CategoryRepository categoryRepository;


    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    public Optional<Category> getPostByCategoryId(int id){
        return categoryRepository.findById(id);
    }

}
