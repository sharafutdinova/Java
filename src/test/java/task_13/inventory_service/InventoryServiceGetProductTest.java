package task_13.inventory_service;

import Task_13.inventory_service.OutOfStockException;
import Task_13.inventory_service.Product;
import Task_13.inventory_service.StockClosedException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryServiceGetProductTest extends InventoryServiceTest {
    /**
     * Кейсы
     * Склад открыт
     * Получение продукта категории который есть на складе в количестве больше 2
     * Получение продукта категории который есть на складе в количестве 1
     * Получение продукта категории которого нет на складе -> OutOfStockException
     * Получение продукта категории у которого закончились товары -> OutOfStockException
     * Склад закрыт -> OutOfStockException
     */
    @Test
    public void userCanGetExistProductWhenInventoryOpen() throws OutOfStockException {
        inventoryService.setInventoryOpen(true);
        addProductToInventoryService(baseProduct_1);
        addProductToInventoryService(baseProduct_1);
        addProductToInventoryService(baseProduct_1);
        Product actualProduct = inventoryService.getProduct(baseProduct_1.getCategory());
        assertTrue(compareProduct(baseProduct_1, actualProduct));
        List<Product> categoryProducts = inventoryService.getProducts().get(baseProduct_1.getCategory());
        assertEquals(2, categoryProducts.size());
    }

    @Test
    public void userCanGetLastProductFromCategoryWhenInventoryOpen() throws OutOfStockException {
        inventoryService.setInventoryOpen(true);
        addProductToInventoryService(baseProduct_1);
        Product actualProduct = inventoryService.getProduct(baseProduct_1.getCategory());
        assertTrue(compareProduct(baseProduct_1, actualProduct));
        List<Product> categoryProducts = inventoryService.getProducts().get(baseProduct_1.getCategory());
        assertEquals(0, categoryProducts.size());
    }

    @Test
    public void userCannotGetProductFromEmptyCategoryWhenInventoryOpen() throws OutOfStockException {
        inventoryService.setInventoryOpen(true);
        addProductToInventoryService(baseProduct_1);
        Product actualProduct = inventoryService.getProduct(baseProduct_1.getCategory());
        assertTrue(compareProduct(baseProduct_1, actualProduct));
        List<Product> categoryProducts = inventoryService.getProducts().get(baseProduct_1.getCategory());
        assertEquals(0, categoryProducts.size());
        assertThrows(OutOfStockException.class, () -> inventoryService.getProduct(baseProduct_1.getCategory()), "При получении товара, с пустой категории не было получено исключения OutOfStockException");
    }

    @Test
    public void userCannotGetProductFromNotExistCategoryWhenInventoryOpen() {
        inventoryService.setInventoryOpen(true);
        addProductToInventoryService(baseProduct_1);
        assertThrows(OutOfStockException.class, () -> inventoryService.getProduct(baseProduct_2.getCategory()), "При получении товара, которого нет в списке не было получено исключения OutOfStockException");
        assertEquals(1, inventoryService.getProducts().size());
    }

    @Test
    public void userCannotGetProductWhenInventoryClosed() throws StockClosedException {
        inventoryService.setInventoryOpen(true);
        addProductToInventoryService(baseProduct_1);
        inventoryService.setInventoryOpen(false);
        assertThrows(StockClosedException.class, () -> inventoryService.getProduct(baseProduct_1.getCategory()), "При получении товара, при закрытом складе не было получено исключения StockClosedException");
        assertEquals(1, inventoryService.getProducts().size());
    }

    @Test
    public void userCannotGetProductWithNullCategory() {
        inventoryService.setInventoryOpen(true);
        assertThrows(IllegalArgumentException.class, () -> inventoryService.getProduct(null), "При получении товара, с категорией = null не было получено исключения IllegalArgumentException");
    }

    @Test
    public void userCannotGetProductWithEmptyCategory() {
        inventoryService.setInventoryOpen(true);
        assertThrows(IllegalArgumentException.class, () -> inventoryService.getProduct(""), "При получении товара, с пустой категорией не было получено исключения IllegalArgumentException");
    }
}
