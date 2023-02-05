package com.example.product_jsp.service.impl;

import com.example.product_jsp.model.Product;
import com.example.product_jsp.repository.IProductRepository;
import com.example.product_jsp.repository.impl.ProductRepositoryImpl;
import com.example.product_jsp.service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
private IProductRepository iProductRepository = new ProductRepositoryImpl();
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(iProductRepository.findAll());
    }

    @Override
    public void addNewProduct(Product product) {
        iProductRepository.addNewProduct(product);
    }

    @Override
    public Product findProductById(int id) {
        return iProductRepository.findProductById(id);
    }

    @Override
    public List<Product> searchProductByName(String name) {
        return iProductRepository.searchProductByName(name);
    }

    @Override
    public void updateProduct(int id, Product product) {
        iProductRepository.updateProduct(id, product);
    }

    @Override
    public void deleteProduct(int id) {
        iProductRepository.deleteProduct(id);
    }
}
