package task_13.inventory_service;

import Task_13.inventory_service.OutOfStockException;
import Task_13.inventory_service.Product;
import Task_13.inventory_service.StockClosedException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryServiceFilterProductTest extends InventoryServiceTest {
    /**
     * Кейсы
     * Склад открыт
     * Фильтрация для существующей категории в диапазоне продуктов склада (цены равны границам)
     * Фильтрация для существующей категории в диапазоне продуктов склада для разных типов цены
     * Фильтрация для существующей категории в диапазоне вне продуктов склада (+-1 от цены продуктов)
     * Фильтрация для существующей пустой категории
     * Фильтрация для несуществующей категории
     * Фильтрация при min>max
     * Склад закрыт -> StockClosedException
     */

    //Несколько продуктов в отфильтрованном списке, расширение границ цена на 1
    @Test
    public void userCanGetFilteredListForExistsCategoryWhenInventoryOpen() throws OutOfStockException {
        inventoryService.setInventoryOpen(true);
        addProductToInventoryService(baseProduct_2);
        addProductToInventoryService(baseProduct_3);
        List<Product> filteredCategory = inventoryService.filterProductsByPriceInCategory(baseProduct_2.getCategory(), baseProduct_2.getPrice() - 1, baseProduct_3.getPrice() + 1);
        assertEquals(2, filteredCategory.size());
        assertTrue(filteredCategory.contains(baseProduct_2));
        assertTrue(filteredCategory.contains(baseProduct_3));
    }

    //Один продукт в отфильтрованном списке, min и max равны цене
    @Test
    public void userCanGetFilteredListForExistsCategoryWithPricesEqualToBorder() throws OutOfStockException {
        inventoryService.setInventoryOpen(true);
        addProductToInventoryService(baseProduct_2);
        addProductToInventoryService(baseProduct_3);
        List<Product> filteredCategory = inventoryService.filterProductsByPriceInCategory(baseProduct_2.getCategory(), baseProduct_2.getPrice(), baseProduct_2.getPrice());
        assertEquals(1, filteredCategory.size());
        assertTrue(filteredCategory.contains(baseProduct_2));
        assertFalse(filteredCategory.contains(baseProduct_3));
    }

    //Пустой отфильтрованный спискок, сужение границ цен на 1
    @Test
    public void userCanGetEmptyListWhenPricesLessThanBorder() throws OutOfStockException {
        inventoryService.setInventoryOpen(true);
        addProductToInventoryService(baseProduct_2);
        addProductToInventoryService(baseProduct_3);
        List<Product> filteredCategory = inventoryService.filterProductsByPriceInCategory(baseProduct_2.getCategory(), baseProduct_2.getPrice() + 1, baseProduct_3.getPrice() - 1);
        assertEquals(0, filteredCategory.size());
        assertFalse(filteredCategory.contains(baseProduct_2));
        assertFalse(filteredCategory.contains(baseProduct_3));
    }

    //Пустой отфильтрованный список для существующей категории
    @Test
    public void userCanGetEmptyListWhenPricesGreaterThanBorder() throws OutOfStockException {
        inventoryService.setInventoryOpen(true);
        addProductToInventoryService(baseProduct_2);
        addProductToInventoryService(baseProduct_3);
        List<Product> filteredCategory = inventoryService.filterProductsByPriceInCategory(baseProduct_2.getCategory(), baseProduct_3.getPrice() + 1, baseProduct_3.getPrice() + 2);
        assertEquals(0, filteredCategory.size());
    }

    //Фильтрация в пустой категории
    @Test
    public void userCannotGetFilteredProductsForEmptyCategory() throws OutOfStockException {
        inventoryService.setInventoryOpen(true);
        addProductToInventoryService(baseProduct_1);
        inventoryService.getProduct(baseProduct_1.getCategory());
        assertThrows(OutOfStockException.class, () -> inventoryService.filterProductsByPriceInCategory(baseProduct_1.getCategory(), baseProduct_1.getPrice(), baseProduct_1.getPrice()), "При фильтрации продуктов в пустой категории не было исключения OutOfStockException");
    }

    //Фильтрация в несуществующей категории
    @Test
    public void userCannotGetFilteredProductsForNotExistCategory() {
        inventoryService.setInventoryOpen(true);
        addProductToInventoryService(baseProduct_1);
        assertThrows(OutOfStockException.class, () -> inventoryService.filterProductsByPriceInCategory(baseProduct_2.getCategory(), baseProduct_2.getPrice(), baseProduct_2.getPrice()), "При фильтрации продуктов в несуществующей категории не было исключения OutOfStockException");
    }

    //Фильтрация при закрытом складе
    @Test
    public void userCannotGetFilteredProductsWhenInventoryClosed() throws StockClosedException {
        inventoryService.setInventoryOpen(true);
        addProductToInventoryService(baseProduct_1);
        inventoryService.setInventoryOpen(false);
        assertThrows(StockClosedException.class, () -> inventoryService.filterProductsByPriceInCategory(baseProduct_1.getCategory(), baseProduct_1.getPrice(), baseProduct_1.getPrice()), "При фильтрации в закрытом складе не было исключения StockClosedException");
    }

    //Фильтрация при min>max
    @Test
    public void userCannotFilterListWhenMinGreaterThanMax() throws IllegalArgumentException {
        inventoryService.setInventoryOpen(true);
        assertThrows(IllegalArgumentException.class, () -> inventoryService.filterProductsByPriceInCategory("base", 100.0, 90.0), "При фильтрации со значениями min > max не было исключения IllegalArgumentException");
    }

    @Test
    public void userCannotFilterListByNullCategory() {
        inventoryService.setInventoryOpen(true);
        assertThrows(IllegalArgumentException.class, () -> inventoryService.filterProductsByPriceInCategory(null, 10.0, 100.0), "При получении списка товаров с категорией = null не было получено исключения IllegalArgumentException");
    }

    @Test
    public void userCannotFilterListByEmptyCategory() {
        inventoryService.setInventoryOpen(true);
        assertThrows(IllegalArgumentException.class, () -> inventoryService.filterProductsByPriceInCategory("", 10.0, 100.0), "При получении списка товаров с пустой категорией не было получено исключения IllegalArgumentException");
    }
}
