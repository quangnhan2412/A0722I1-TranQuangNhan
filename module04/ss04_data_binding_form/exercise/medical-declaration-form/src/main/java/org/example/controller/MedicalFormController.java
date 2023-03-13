package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/form")
public class MedicalFormController {

    @GetMapping("/")
    public String displayForm(Model model){
        model.addAttribute()
    }
}
