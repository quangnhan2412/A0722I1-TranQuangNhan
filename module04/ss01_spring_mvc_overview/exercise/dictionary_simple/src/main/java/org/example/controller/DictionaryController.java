package org.example.controller;

import org.example.bean.SearchWord;
import org.example.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping("trans")
    public String displayTrans() {
        return "trans";
    }
    @PostMapping("/trans")
    public String displayResult(@RequestParam String trans , Model model){
        String result = dictionaryService.searchEng(trans);
        SearchWord searchWord = new SearchWord(trans,result);
        model.addAttribute("searchWord",searchWord);
        return "trans";
    }
}
