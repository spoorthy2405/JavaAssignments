package com.Assignment;
public class Product {

    private int id;
    private String name;
    private String category;
    private double price;
    private int quantity;
    private String addedDate; // DD-MM-YYYY

    public Product(int id, String name, String category,
                   double price, int quantity, String addedDate) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.addedDate = addedDate;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getAddedDate() { return addedDate; }

    // Setters (for update)
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return id + " | " + name + " | " + category +
                " | $" + price + " | Qty: " + quantity +
                " | " + addedDate;
    }
}