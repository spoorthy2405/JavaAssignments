package com.Assignment;
import java.util.*;

public class ProductManagerUsingMap {

    private Map<Integer, Product> products;

    public ProductManagerUsingMap() {
        products = new HashMap<>();
    }

    // Add
    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    // Get by ID
    public Product getProductById(int id) {
        return products.get(id);
    }

    // Get All
    public Map<Integer, Product> getProducts() {
        return products;
    }

    // Remove
    public void removeProduct(int id) {
        products.remove(id);
    }

    // Sort by Name
    public void sortByName() {

        List<Product> list = new ArrayList<>(products.values());

        list.sort(Comparator.comparing(Product::getName));

        products.clear();

        for (Product p : list) {
            products.put(p.getId(), p);
        }
    }

    // Sort by Price
    public void sortByPrice() {

        List<Product> list = new ArrayList<>(products.values());

        list.sort(Comparator.comparingDouble(Product::getPrice));

        products.clear();

        for (Product p : list) {
            products.put(p.getId(), p);
        }
    }
}
