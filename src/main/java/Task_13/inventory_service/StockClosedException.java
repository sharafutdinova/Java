package Task_13.inventory_service;

public class StockClosedException extends RuntimeException {
    public StockClosedException(String message) {
        super(message);
    }
}
