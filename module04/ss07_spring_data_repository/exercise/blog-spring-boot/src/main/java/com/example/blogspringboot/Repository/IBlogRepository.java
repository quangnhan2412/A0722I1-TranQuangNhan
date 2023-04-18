package com.example.blogspringboot.Repository;

import com.example.blogspringboot.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IBlogRepository  extends JpaRepository<Blog, Long> {
Blog findByBlogId(Long id);
    @Query(value = "select * from Blog where blogger_name like %:name%", nativeQuery = true)
    Page<Blog> findByBloggerName(String name, Pageable pageable);
}
