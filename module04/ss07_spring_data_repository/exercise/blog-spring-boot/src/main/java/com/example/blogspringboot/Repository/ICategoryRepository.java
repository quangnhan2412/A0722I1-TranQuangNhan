package com.example.blogspringboot.Repository;



import com.example.blogspringboot.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;




public interface ICategoryRepository extends JpaRepository<Category, Long> {
    Category findByCategoryId(Long id);
}
