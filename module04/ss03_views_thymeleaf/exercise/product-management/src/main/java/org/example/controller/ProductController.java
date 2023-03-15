package org.example.controller;


import org.example.model.Product;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String index(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product) {
        product.setIdProduct((int) (Math.random() * 100));
        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product) {
        productService.update(product.getIdProduct(), product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        productService.remove(product.getIdProduct());
        redirectAttributes.addFlashAttribute("success", "Remove product successfully");
        return "redirect:/product";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "/view";
    }

    @GetMapping("/search")
    public  String index(@RequestParam("searchNameProduct") String name, ModelMap modelMap){
        List<Product> productList = productService.searchProduct(name);
        modelMap.addAttribute("productList",productList);
        return "/index";
    }
}
