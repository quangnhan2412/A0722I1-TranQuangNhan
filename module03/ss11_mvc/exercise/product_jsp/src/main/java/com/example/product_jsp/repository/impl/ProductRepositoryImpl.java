package com.example.product_jsp.repository;

import com.example.product_jsp.model.Product;
import com.example.product_jsp.repository.impl.IProductRepository;

import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {
    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public void addNewProduct(Product product) {

    }

    @Override
    public Product findProductById(int id) {
        return null;
    }

    @Override
    public List<Product> searchProductByName(String name) {
        return null;
    }

    @Override
    public void updateProduct(int id, Product product) {

    }

    @Override
    public void deleteProduct(int id) {

    }
}
