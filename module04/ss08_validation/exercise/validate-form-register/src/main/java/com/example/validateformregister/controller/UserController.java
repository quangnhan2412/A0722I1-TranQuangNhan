package com.example.validateformregister.controller;

import com.example.validateformregister.model.User;
import com.example.validateformregister.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;


@Controller
public class UserController {
    @Autowired
    IUserService iUserService;
    @GetMapping("/create")
    public String viewCreate(Model model) {
        model.addAttribute("users", new User());
        return "/index";
    }

    @PostMapping("/save")
    public String saveUser(@Valid @ModelAttribute("users") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("lỗi ?");
            return "/index";
        }else {
            iUserService.create(user);
            return "/result";
        }
    }
}
