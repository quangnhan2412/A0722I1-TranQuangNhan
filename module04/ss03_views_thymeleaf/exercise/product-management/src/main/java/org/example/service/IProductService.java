package org.example.service;

import org.example.model.Product;

import java.util.List;

public interface IProductService {
List<Product> findAll();
void save(Product product);
Product findById(int id);
void update(int id,Product product);
List<Product> searchProduct(String nameProduct);
void remove(int id);
}
