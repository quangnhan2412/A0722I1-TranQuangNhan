package com.example.blogspringboot.service.impl;

import com.example.blogspringboot.Repository.IBlogRepository;
import com.example.blogspringboot.model.Blog;
import com.example.blogspringboot.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {
@Autowired
private IBlogRepository blogRepository;
    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Blog blog) {
blogRepository.delete(blog);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findByBlogId(id);
    }

    @Override
    public Page<Blog> findByCategoryContains(String name, Pageable pageable) {
        return blogRepository.findByBloggerName(name,pageable);
    }
}
