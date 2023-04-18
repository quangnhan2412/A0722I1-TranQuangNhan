package com.example.managentphone.controller;

import com.example.managentphone.model.Smartphone;
import com.example.managentphone.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("/phones/list");
        modelAndView.addObject("smartphones", smartphoneService.findAll());
        return modelAndView;
    }


    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> allPhone() {
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<Smartphone> findById(@RequestParam("id")Long id) {
        return new ResponseEntity<>(smartphoneService.findById(id).orElse(new Smartphone()), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
        if(!smartphoneOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(),HttpStatus.OK);
    }
//    @PutMapping("/{id}")
//    public ResponseEntity<Smartphone> updateSmartphone(@PathVariable Long id){
//        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
//        return smartphoneOptional.map(smartphone -> new ResponseEntity<>(smartphoneService.save(smartphone),HttpStatus.NO_CONTENT)).orElseGet(()
//                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }

}
