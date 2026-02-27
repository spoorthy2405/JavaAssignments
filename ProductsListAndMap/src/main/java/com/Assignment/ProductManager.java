package com.Assignment;
import java.util.*;

public class ProductManager {

    private List<Product> products;

    public ProductManager() {
        products = new ArrayList<>();
    }

    // Add
    public void addProduct(Product product) {
        products.add(product);
    }

    // Get All
    public List<Product> getProducts() {
        return products;
    }

    // Get by ID
    public Product getProductById(int id) {
        for (Product p : products) {
            if (p.getId() == id)
                return p;
        }
        return null;
    }

    // Get by Category
    public List<Product> getProductsByCategory(String category) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.getCategory().equalsIgnoreCase(category))
                result.add(p);
        }
        return result;
    }

    // Update price & quantity
    public boolean updateProduct(int id, double price, int quantity) {
        Product p = getProductById(id);
        if (p != null) {
            p.setPrice(price);
            p.setQuantity(quantity);
            return true;
        }
        return false;
    }

    // Remove
    public boolean removeProduct(int id) {
        return products.removeIf(p -> p.getId() == id);
    }

    // -------- Sorting --------

    public void sortByName() {
        products.sort(Comparator.comparing(Product::getName));
    }

    public void sortByPrice() {
        products.sort(Comparator.comparingDouble(Product::getPrice));
    }

    public void sortByQuantity() {
        products.sort(Comparator.comparingInt(Product::getQuantity));
    }

    public void sortByDate() {
        products.sort((a, b) -> {

            String[] d1 = a.getAddedDate().split("-");
            String[] d2 = b.getAddedDate().split("-");

            int yearCompare = Integer.compare(
                    Integer.parseInt(d1[2]),
                    Integer.parseInt(d2[2])
            );
            if (yearCompare != 0) return yearCompare;

            int monthCompare = Integer.compare(
                    Integer.parseInt(d1[1]),
                    Integer.parseInt(d2[1])
            );
            if (monthCompare != 0) return monthCompare;

            return Integer.compare(
                    Integer.parseInt(d1[0]),
                    Integer.parseInt(d2[0])
            );
        });
    }
}
