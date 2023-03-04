package service;

import bean.Product;
import repository.ProductRepository;
import repository.ProductRepositoryImpl;


import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository = new ProductRepositoryImpl();
    @Override
    public List<Product> selectAllProduct() {
        return productRepository.selectAllProduct();
    }

    @Override
    public Product getProductById(int id) {
        return null;
    }

    @Override
    public List<Product> searchProductByName(String nameProduct) {
        return productRepository.searchProductByName(nameProduct);
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        return productRepository.updateProduct(product);
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        return productRepository.deleteProduct(id);
    }
}
