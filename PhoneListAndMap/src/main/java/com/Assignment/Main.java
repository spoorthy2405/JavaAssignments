package com.Assignment;

public class Main {

    public static void main(String[] args) {

        PhoneManager manager = new PhoneManager();

        manager.addPhone(new Phone(100, "iPhone 13", "Apple", 999.99, 12, "19-10-2005"));
        manager.addPhone(new Phone(200, "Galaxy S21", "Samsung", 799.99, 8, "25-12-2021"));
        manager.addPhone(new Phone(300, "Pixel 6", "Google", 699.99, 6, "12-11-2025"));

        System.out.println("---- All Phones ----");
        for (Phone p : manager.getPhones()) {
            System.out.println(p);
        }

        System.out.println("\n---- Sorted by Price ----");
        manager.sortByPrice();
        manager.getPhones().forEach(System.out::println);

        System.out.println("\n---- Sorted by Name ----");
        manager.sortByName();
        manager.getPhones().forEach(System.out::println);

        System.out.println("\n---- Sorted by Camera MP ----");
        manager.sortByCamMp();
        manager.getPhones().forEach(System.out::println);

        System.out.println("\n---- Sorted by Release Date ----");
        manager.sortByReleaseDate();
        manager.getPhones().forEach(System.out::println);

        System.out.println("\n---- Remove ID 200 ----");
        manager.removePhoneById(200);
        manager.getPhones().forEach(System.out::println);
    }
}