package com.example.addproductcart.repository;

import com.example.addproductcart.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
}
