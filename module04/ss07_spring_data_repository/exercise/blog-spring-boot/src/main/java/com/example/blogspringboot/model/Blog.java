package com.example.blogspringboot.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long blogId;
    private String blogName;
    private String blogContent;
    private String bloggerName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dayWrite;

    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "categoryId")
    private Category category;

    public Blog() {
    }

    public Blog(Long blogId, String blogName, String blogContent, String bloggerName, Date dayWrite, Category category) {
        this.blogId = blogId;
        this.blogName = blogName;
        this.blogContent = blogContent;
        this.bloggerName = bloggerName;
        this.dayWrite = dayWrite;
        this.category = category;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public String getBloggerName() {
        return bloggerName;
    }

    public void setBloggerName(String bloggerName) {
        this.bloggerName = bloggerName;
    }

    public Date getDayWrite() {
        return dayWrite;
    }

    public void setDayWrite(Date dayWrite) {
        this.dayWrite = dayWrite;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
