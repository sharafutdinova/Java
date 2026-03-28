package practice_8.library;

import practice_8.library.exceptions.BookNotFoundException;
import practice_8.library.exceptions.InvalidBookException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    //Непроверяемое исключение
    public void addBook(Book book) throws InvalidBookException {
        if (books.contains(book)) {
            throw new InvalidBookException("Такая книга уже есть!");
        } else books.add(book);
    }

    //Проверяемое исключение
    public Book getBook(String name) throws BookNotFoundException {
        AtomicReference<Book> foundBook = new AtomicReference<>();
        books.forEach(book -> {
            if (book.getName() == name) {
                foundBook.set(book);
            }
        });
        if (foundBook.get() == null) {
            throw new BookNotFoundException("Книга не найдена");
        }
        return foundBook.get();
    }
}
