package com.assignment.jdbcproducts.ui;
import com.assignment.jdbcproducts.dao.ProductDao;
import com.assignment.jdbcproducts.dao.ProductDaoImpl;
import com.assignment.jdbcproducts.entity.Product;

public class Main {

    public static void main(String[] args) {

        ProductDao dao = new ProductDaoImpl();

        dao.addProduct(new Product(1, "Laptop", 80000, "Electronics", 5));
        dao.addProduct(new Product(2, "Shoes", 2500, "Fashion", 20));

        System.out.println("All Products:");
        dao.findAll().forEach(System.out::println);

        System.out.println("Find By ID:");
        System.out.println(dao.findById(1));

        dao.updateProduct(new Product(1, "Gaming Laptop", 95000, "Electronics", 3));

        dao.deleteProduct(2);

        System.out.println("Sorted By Price:");
        dao.sortByPrice().forEach(System.out::println);
    }
}
