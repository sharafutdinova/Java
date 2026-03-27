package practice_7.contact_book;

import java.util.HashMap;

public class ContactBook {
    private HashMap<String, Integer> contacts;

    public ContactBook() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, Integer phone) {
        contacts.put(name, phone);
    }

    public Integer getPhone(String name) {
        return contacts.get(name);
    }

    public void updatePhone(String name, Integer phone) {
        contacts.put(name, phone);
    }

    public void printContacts() {
        contacts.forEach((name, phone) -> {
            System.out.println("Name " + name + " phone " + phone);
        });
    }
}
