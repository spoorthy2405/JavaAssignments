package com.assignment.jdbcproducts.dao;
import com.assignment.jdbcproducts.entity.Product;
import java.util.List;

public interface ProductDao {

    void addProduct(Product p);

    List<Product> findAll();

    Product findById(int id);

    void updateProduct(Product p);

    void deleteProduct(int id);

    List<Product> sortByName();

    List<Product> sortByPrice();

    List<Product> sortByCategory();

    List<Product> filterByCategory(String category);

    List<Product> filterByPrice(double min, double max);
}
