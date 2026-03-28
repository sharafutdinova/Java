package practice_8.generic;

import practice_8.library.Book;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Box<String> boxString = new Box<>();
        Box<Integer> boxInteger = new Box<>();
        Box<Book> boxBook = new Box<>();

        boxString.setElement("String");
        boxInteger.setElement(13);
        boxBook.setElement(new Book("Война и мир", "Толстой"));

        System.out.println(boxInteger.getElement());
        System.out.println(boxString.getElement());
        System.out.println(boxBook.getElement());

        Box test = boxInteger;
        test.setElement("tr");
        System.out.println(test.getElement());
        Object obj = test.getElement();
        System.out.println(obj.getClass());
    }

    public static void print(List<Integer> list){
        System.out.println("Integers");
    }
}
