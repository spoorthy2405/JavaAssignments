package com.Assignment;
import java.util.*;

public class PhoneManagerUsingMap {

    private Map<Integer, Phone> phones;

    public PhoneManagerUsingMap() {
        phones = new HashMap<>();
    }

    public void addPhone(Phone phone) {
        phones.put(phone.getId(), phone);
    }

    public Phone getPhoneById(int id) {
        return phones.get(id);
    }

    public Map<Integer, Phone> getPhones() {
        return phones;
    }

    public void removePhoneById(int id) {
        phones.remove(id);
    }

    // Sort by Name
    public void sortByName() {

        List<Phone> list = new ArrayList<>(phones.values());

        Collections.sort(list, (a, b) ->
                a.getName().compareTo(b.getName()));

        phones.clear();

        for (Phone p : list) {
            phones.put(p.getId(), p);
        }
    }
}