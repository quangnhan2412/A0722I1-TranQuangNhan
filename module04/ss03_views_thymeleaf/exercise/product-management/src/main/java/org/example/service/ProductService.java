package org.example.service;

import org.example.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {
    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "Milo", "100calo", "protein", "6 exp"));
        productMap.put(2, new Product(2, "TH milk", "80calo", "protein", "5 exp"));
        productMap.put(3, new Product(3, "vinaMILK", "120calo", "protein", "7 exp"));
        productMap.put(4, new Product(4, "Grow", "70calo", "protein", "9 exp"));
        productMap.put(5, new Product(5, "Alpha", "150calo", "protein", "10 exp"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getIdProduct(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public List<Product> searchProduct(String nameProduct) {
        List<Product> productList = new ArrayList<>();
        for (Product product : productMap.values()) {
            if (product.getNameProduct().contains(nameProduct)) {
                productList.add(product);
            }
        }
        return productList;
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }
}
