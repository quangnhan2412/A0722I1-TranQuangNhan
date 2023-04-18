package com.example.blogspringboot.service.impl;

import com.example.blogspringboot.model.Category;
import com.example.blogspringboot.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryService categoryService;

    @Override
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @Override
    public void save(Category category) {
        categoryService.save(category);
    }

    @Override
    public Category findById(Long id) {
        return categoryService.findById(id);
    }

    @Override
    public void remove(Category category) {
        categoryService.remove(category);
    }
}
