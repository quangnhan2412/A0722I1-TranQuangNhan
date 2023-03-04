package repository;

import bean.Product;

import java.sql.SQLException;
import java.util.List;

public interface   ProductRepository {
    public List<Product> selectAllProduct();
    Product getProductById(int id);
    List<Product> searchProductByName(String nameProduct);
    public boolean updateProduct(Product product) throws SQLException;

    public boolean deleteProduct(int id) throws SQLException;
}
