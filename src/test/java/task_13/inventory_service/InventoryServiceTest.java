package task_13.inventory_service;

import Task_13.inventory_service.Product;
import Task_13.inventory_service.InventoryService;
import org.junit.jupiter.api.BeforeEach;

public class InventoryServiceTest {
    protected InventoryService inventoryService;
    protected Product baseProduct_1 = new Product("Apple", 4.7, "Fruit");
    protected Product baseProduct_2 = new Product("Potato", 3, "Vegetables");
    protected Product baseProduct_3 = new Product("Tomato", 6.9, "Vegetables");

    @BeforeEach
    public void testSetup() {
        inventoryService = new InventoryService();
    }

    public boolean compareProduct(Product expected, Product actual) {
        return expected.getName().equals(actual.getName()) && expected.getCategory().equals(actual.getCategory()) && Double.valueOf(expected.getPrice()).equals(actual.getPrice());
    }

    public void addProductToInventoryService(Product product) {
        inventoryService.addProduct(product);
    }
}
