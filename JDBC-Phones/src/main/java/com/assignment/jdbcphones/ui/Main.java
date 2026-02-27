package com.assignment.jdbcphones.ui;
import com.assignment.jdbcphones.dao.PhoneDao;
import com.assignment.jdbcphones.dao.PhoneDaoImpl;
import com.assignment.jdbcphones.entity.Phone;

public class Main {

    public static void main(String[] args) {

        PhoneDao dao = new PhoneDaoImpl();

        dao.addPhone(new Phone(1, "iPhone 15", 90000, "Apple", "Premium"));
        dao.addPhone(new Phone(2, "Galaxy S23", 85000, "Samsung", "Premium"));

        System.out.println("All Phones:");
        dao.findAll().forEach(System.out::println);

        System.out.println("Find By ID:");
        System.out.println(dao.findPhoneById(1));

        dao.updatePhone(new Phone(1, "iPhone 15 Pro", 120000, "Apple", "Ultra"));

        dao.deletePhone(2);
    }
}