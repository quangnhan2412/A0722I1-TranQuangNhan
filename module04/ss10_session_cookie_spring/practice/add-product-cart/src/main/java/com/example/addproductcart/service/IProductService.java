package com.example.addproductcart.service;

import com.example.addproductcart.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(Long id);


}
