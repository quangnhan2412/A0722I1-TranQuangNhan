package com.example.product_jsp.repository;

import com.example.product_jsp.model.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> findAll();
    void addNewProduct(Product product);
    Product findProductById(int id);
    List<Product> searchProductByName(String name);
    void updateProduct(int id,Product product);
    void deleteProduct(int id);
}
