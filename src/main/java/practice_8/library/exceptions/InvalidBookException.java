package practice_8.library.exceptions;

//Непроверяемое исключение
public class InvalidBookException extends RuntimeException {
    public InvalidBookException(String message) {
        super(message);
    }
}
