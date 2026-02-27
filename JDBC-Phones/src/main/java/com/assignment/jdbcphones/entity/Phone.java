package com.assignment.jdbcphones.entity;
public class Phone {

    private int id;
    private String name;
    private double cost;
    private String brand;
    private String category;

    public Phone(int id, String name, double cost, String brand, String category) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.brand = brand;
        this.category = category;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getCost() { return cost; }
    public String getBrand() { return brand; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return id + " | " + name + " | " + cost + " | " + brand + " | " + category;
    }
}