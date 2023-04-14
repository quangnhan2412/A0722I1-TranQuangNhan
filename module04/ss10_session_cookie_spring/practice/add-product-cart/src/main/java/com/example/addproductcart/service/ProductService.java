package com.example.addproductcart.service;

import com.example.addproductcart.model.Product;
import com.example.addproductcart.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@Service
public class ProductService implements  IProductService{
    private Map<Product, Integer> products = new HashMap<>();
    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public Iterable<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return iProductRepository.findById(id);
    }


}
