package Task_13.inventory_service;

public class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}
