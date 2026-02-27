package com.assignment.jdbcphones.dao;
import com.assignment.jdbcphones.entity.Phone;
import java.util.List;

public interface PhoneDao {

    void addPhone(Phone p);

    List<Phone> findAll();

    Phone findPhoneById(int id);

    void updatePhone(Phone p);

    void deletePhone(int id);

    List<Phone> sortByName();

    List<Phone> sortByCost();

    List<Phone> sortByCategory();

    List<Phone> filterByCategory(String category);

    List<Phone> filterByCost(double min, double max);
}
