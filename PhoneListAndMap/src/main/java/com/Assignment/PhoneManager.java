package com.Assignment;
import java.util.*;

public class PhoneManager {

    private List<Phone> phones;

    public PhoneManager() {
        phones = new ArrayList<>();
    }

    // Add phone
    public void addPhone(Phone phone) {
        phones.add(phone);
    }

    // Get all phones
    public List<Phone> getPhones() {
        return phones;
    }

    // Get phones by brand
    public List<Phone> getPhonesByBrand(String brand) {
        List<Phone> result = new ArrayList<>();

        for (Phone p : phones) {
            if (p.getBrand().equalsIgnoreCase(brand)) {
                result.add(p);
            }
        }
        return result;
    }

    // Get phone by ID
    public Phone getPhoneById(int id) {
        for (Phone p : phones) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    // Remove phone by ID
    public boolean removePhoneById(int id) {
        Phone phone = getPhoneById(id);
        if (phone != null) {
            phones.remove(phone);
            return true;
        }
        return false;
    }

    // -------- SORTING METHODS --------

    // Sort by Name
    class NameComparator implements Comparator<Phone> {
        @Override
        public int compare(Phone a, Phone b) {
            return a.getName().compareTo(b.getName());
        }
    }

    public void sortByName() {
        Collections.sort(phones, new NameComparator());
    }

    // Sort by Price
    public void sortByPrice() {
        Collections.sort(phones, new Comparator<Phone>() {
            @Override
            public int compare(Phone a, Phone b) {
                return Double.compare(a.getPrice(), b.getPrice());
            }
        });
    }

    // Sort by Camera MP
    public void sortByCamMp() {
        Collections.sort(phones, (a, b) ->
                Integer.compare(a.getCameraMP(), b.getCameraMP()));
    }

    // Sort by Release Date (DD-MM-YYYY format)
    public void sortByReleaseDate() {

        Collections.sort(phones, (a, b) -> {

            String[] dateA = a.getReleaseDate().split("-");
            String[] dateB = b.getReleaseDate().split("-");

            int dayA = Integer.parseInt(dateA[0]);
            int monthA = Integer.parseInt(dateA[1]);
            int yearA = Integer.parseInt(dateA[2]);

            int dayB = Integer.parseInt(dateB[0]);
            int monthB = Integer.parseInt(dateB[1]);
            int yearB = Integer.parseInt(dateB[2]);

            if (yearA != yearB)
                return Integer.compare(yearA, yearB);

            if (monthA != monthB)
                return Integer.compare(monthA, monthB);

            return Integer.compare(dayA, dayB);
        });
    }
}
