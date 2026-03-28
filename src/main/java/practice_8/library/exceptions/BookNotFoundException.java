package practice_8.library.exceptions;

//Проверяемое исключение
public class BookNotFoundException extends Exception {
    public BookNotFoundException(String message) {
        super(message);
    }
}
