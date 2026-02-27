package com.Assignment;
public class Main {

    public static void main(String[] args) {

        ProductManager manager = new ProductManager();

        manager.addProduct(new Product(1, "Laptop", "Electronics", 80000, 5, "12-01-2024"));
        manager.addProduct(new Product(2, "Shoes", "Fashion", 2500, 20, "10-02-2023"));
        manager.addProduct(new Product(3, "Phone", "Electronics", 50000, 10, "15-05-2025"));

        System.out.println("---- All Products ----");
        manager.getProducts().forEach(System.out::println);

        System.out.println("\n---- Sort by Price ----");
        manager.sortByPrice();
        manager.getProducts().forEach(System.out::println);

        System.out.println("\n---- Sort by Name ----");
        manager.sortByName();
        manager.getProducts().forEach(System.out::println);

        System.out.println("\n---- Update Product ID 1 ----");
        manager.updateProduct(1, 75000, 8);
        manager.getProducts().forEach(System.out::println);

        System.out.println("\n---- Remove Product ID 2 ----");
        manager.removeProduct(2);
        manager.getProducts().forEach(System.out::println);

        System.out.println("\n---- Using Map ----");
        ProductManagerUsingMap mapManager = new ProductManagerUsingMap();

        mapManager.addProduct(new Product(10, "Tablet", "Electronics", 30000, 7, "01-03-2024"));
        mapManager.addProduct(new Product(20, "Watch", "Fashion", 5000, 15, "11-07-2023"));

        mapManager.sortByName();

        mapManager.getProducts().values().forEach(System.out::println);
    }
}