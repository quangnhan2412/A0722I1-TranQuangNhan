package com.example.addproductcart.controller;

import com.example.addproductcart.model.Cart;
import com.example.addproductcart.model.Product;
import com.example.addproductcart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }
    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", iProductService.findAll());
        return modelAndView;
    }
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = iProductService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }
    @GetMapping("/remove/{id}")
    public String removeToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = iProductService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.removeProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.removeProduct(productOptional.get());
        return "redirect:/shop";
    }

}
