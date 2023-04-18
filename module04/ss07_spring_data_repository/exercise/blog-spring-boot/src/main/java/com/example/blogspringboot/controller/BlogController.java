package com.example.blogspringboot.controller;

import com.example.blogspringboot.model.Blog;
import com.example.blogspringboot.service.IBlogService;
import com.example.blogspringboot.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/blogs")
public class BlogController {
@Autowired
    private IBlogService blogService;
@Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String index(@RequestParam(defaultValue = "") String name, Model model,
                        @PageableDefault(value = 3,
                                sort = "day_write") Pageable pageable) {
        model.addAttribute("blogs", blogService.findByCategoryContains(name, pageable));
        model.addAttribute("name", name);
        return "/blog/index";
    }
@GetMapping(value = "/create")
    public String create(Model model){
        model.addAttribute("categories",categoryService.findAll());
        model.addAttribute("blogs",new Blog());
        return "/blog/create";
    }
    @PostMapping(value="/save")
    public String save(Blog blogs, RedirectAttributes redirect) {
        blogService.save(blogs);
        redirect.addFlashAttribute("success", "Create customer successfully!");
        return "redirect:/blogs";
    }

}
