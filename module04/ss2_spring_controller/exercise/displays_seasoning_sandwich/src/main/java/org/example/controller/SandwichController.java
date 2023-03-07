package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class SandwichController {
    @GetMapping(value = "/home")
    public String displayFormSandwich(){
        return "sandwich";
    }

    @PostMapping(value = "/save")
    public String result(@RequestParam("condiment") String [] condiment , ModelMap modelMap){
                String result = Arrays.toString(condiment);
                modelMap.addAttribute("result",result);
                return "sandwich";
    }
}
