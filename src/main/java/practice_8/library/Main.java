package practice_8.library;

import practice_8.library.exceptions.BookNotFoundException;

public class Main {
    public static void main(String[] args) throws BookNotFoundException {
        Library library = new Library();
        library.addBook(new Book("1994", "Оруэл"));
        library.addBook(new Book("Война и мир", "Толстой"));
        library.addBook(new Book("Идиот", "Достоевский"));
//        library.addBook(new Book("Война и мир", "Толстой"));
        try {
            library.getBook("Войнаи мир");
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage() + ", исключение обработано");
//            throw new BookNotFoundException("mes");
        } finally {
            System.out.println("Test print");
        }
        System.out.println("End");
        System.out.println(test());
        try {
            test2();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage() + ", исключение 1 обработано");
        } catch (Exception e) {
            System.out.println(e.getMessage() + ", исключение 2 обработано");
        }
    }

    public static Integer test() {
        try {
            System.out.println("Test");
            return 10;
        } finally {
            return 11;
        }
    }

    public static void test2() {
        try {
            System.out.println("Test2");
            throw new RuntimeException("try exception AAAAAAA");
        } finally {
            throw new RuntimeException("Finally exception");
        }
    }
}
