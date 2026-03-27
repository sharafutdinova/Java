package practice_7.contact_book;

public class Main {
    public static void main(String[] args) {
        ContactBook contactBook = new ContactBook();
        contactBook.addContact("Alsu", 1518);
        contactBook.addContact("Sasha", 6922);
        contactBook.addContact("Anna", 543);
        contactBook.addContact("Mary", 234);
        contactBook.printContacts();
        contactBook.updatePhone("Alsu", 3137);
        contactBook.printContacts();
        System.out.println(contactBook.getPhone("Alsu"));
    }
}
