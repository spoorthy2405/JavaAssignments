package com.Assignment;

public class Phone {

    private int id;
    private String name;
    private String brand;
    private double price;
    private int cameraMP;
    private String releaseDate;

    public Phone(int id, String name, String brand,
                 double price, int cameraMP, String releaseDate) {

        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.cameraMP = cameraMP;
        this.releaseDate = releaseDate;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public int getCameraMP() {
        return cameraMP;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + brand +
                " | $" + price + " | " +
                cameraMP + "MP | " + releaseDate;
    }
}
