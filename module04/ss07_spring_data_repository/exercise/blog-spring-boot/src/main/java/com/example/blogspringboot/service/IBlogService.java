package com.example.blogspringboot.service;

import com.example.blogspringboot.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);
    void save(Blog blog);

    void remove(Blog blog);

    Blog findById(Long id);

    Page<Blog> findByCategoryContains(String name,Pageable pageable);
}
