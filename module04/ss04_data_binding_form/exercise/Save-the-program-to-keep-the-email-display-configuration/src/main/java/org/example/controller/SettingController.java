package org.example.controller;


import org.example.model.Email;
import org.example.service.IMailElectronicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/email")
public class SettingController {
    @Autowired
    private IMailElectronicService iMailElectronicService;

    @GetMapping("")
    public String displayMail(Model model) {
        List<Email> emailList = iMailElectronicService.showAll();
        model.addAttribute("emailList",emailList );
        return "/list";
    }
    @GetMapping("/updateForm")
    public String showEdit(@RequestParam("id") Integer id, Model model) {
        Email emailBox = iMailElectronicService.findById(id);

        List<String> languagesList = Arrays.asList("English", "Vietnamese", "Japanese", "Chinese");
        List<Integer> pageSizeList = Arrays.asList(5, 10, 15, 25, 50, 100);

        model.addAttribute("emailBox", emailBox);
        model.addAttribute("languagesList", languagesList);
        model.addAttribute("pageSizeList", pageSizeList);

        return "/edit";
    }
    @PostMapping("/update")
    public String edit(Email emailBox, RedirectAttributes redirectAttributes) {
        iMailElectronicService.update(emailBox);
        redirectAttributes.addFlashAttribute("message", "Edit Success");
        return "redirect:/email";
    }
}
