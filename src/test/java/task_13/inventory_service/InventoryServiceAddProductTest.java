package task_13.inventory_service;

import Task_13.inventory_service.Product;
import Task_13.inventory_service.StockClosedException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryServiceAddProductTest extends InventoryServiceTest {
    /**
     * Кейсы
     * Склад открыт и закрыт
     * Добавить новый продукт в пустой список
     * Добавить новый продукт в непустой список
     * Добавить продукт в существующую категорию с новым названием продукта в непустой список
     * Добавить продукт в существующую категорию с тем же названием продукта в непустой список
     * Добавить продукты с разными типами цен (целое и дробное)
     */
    @Test
    public void userCanAddProductToEmptyListWhenInventoryOpen() {
        inventoryService.setInventoryOpen(true);
        inventoryService.addProduct(baseProduct_1);
        assertEquals(1, inventoryService.getProducts().size());
        assertTrue(inventoryService.getProducts().containsKey(baseProduct_1.getCategory()));
        Product actualProduct = inventoryService.getProducts().get(baseProduct_1.getCategory()).getFirst();
        assertTrue(compareProduct(baseProduct_1, actualProduct), "Ожидаемый и актуальный товары не равны");
    }

    @Test
    public void userCanNotAddProductToEmptyListWhenInventoryClosed() {
        inventoryService.setInventoryOpen(false);
        assertThrows(StockClosedException.class, () -> inventoryService.addProduct(baseProduct_2), "При добавлении товара в закрытый склад не было исключения StockClosedException");
        assertEquals(0, inventoryService.getProducts().size());
    }

    @Test
    public void userCanAddProductToNotEmptyListWhenInventoryOpen() {
        inventoryService.setInventoryOpen(true);
        String category_1 = baseProduct_1.getCategory();
        String category_2 = baseProduct_2.getCategory();
        inventoryService.addProduct(baseProduct_1);
        inventoryService.addProduct(baseProduct_2);

        assertEquals(2, inventoryService.getProducts().size());
        assertTrue(inventoryService.getProducts().containsKey(category_1));
        Product actualProduct_1 = inventoryService.getProducts().get(category_1).getFirst();
        assertTrue(compareProduct(baseProduct_1, actualProduct_1), "Ожидаемый и актуальный товары не равны");
        assertTrue(inventoryService.getProducts().containsKey(category_2));
        Product actualProduct_2 = inventoryService.getProducts().get(category_2).getFirst();
        assertTrue(compareProduct(baseProduct_2, actualProduct_2), "Ожидаемый и актуальный товары не равны");
    }

    @Test
    public void userCanAddNewProductToTheSameCategoryInListWhenInventoryOpen() {
        inventoryService.setInventoryOpen(true);
        String category = baseProduct_1.getCategory();
        Product expectedProduct_2 = new Product("Potato", 3.6, category);
        inventoryService.addProduct(baseProduct_1);
        inventoryService.addProduct(expectedProduct_2);

        assertEquals(1, inventoryService.getProducts().size());
        assertTrue(inventoryService.getProducts().containsKey(category));
        List<Product> categoryProducts = inventoryService.getProducts().get(category);
        assertEquals(2, categoryProducts.size());
        assertTrue(categoryProducts.contains(baseProduct_1));
        assertTrue(categoryProducts.contains(new Product("Potato", 3.6, category)));
    }

    @Test
    public void userCanAddSameProductToTheSameCategoryInListWhenInventoryOpen() {
        inventoryService.setInventoryOpen(true);
        String category = baseProduct_1.getCategory();
        inventoryService.addProduct(baseProduct_1);
        inventoryService.addProduct(baseProduct_1);

        assertEquals(1, inventoryService.getProducts().size());
        assertTrue(inventoryService.getProducts().containsKey(category));
        List<Product> categoryProducts = inventoryService.getProducts().get(category);
        assertEquals(2, categoryProducts.size());
        assertTrue(categoryProducts.contains(baseProduct_1));
    }

    @Test
    public void userCanNotAddProductToNotEmptyListWhenInventoryClosed() {
        inventoryService.setInventoryOpen(true);
        String category_1 = baseProduct_1.getCategory();
        inventoryService.addProduct(baseProduct_1);
        inventoryService.setInventoryOpen(false);
        String category_2 = baseProduct_2.getCategory();
        assertThrows(StockClosedException.class, () -> inventoryService.addProduct(baseProduct_2), "При добавлении товара в закрытый склад не было исключения StockClosedException");

        assertEquals(1, inventoryService.getProducts().size());
        assertTrue(inventoryService.getProducts().containsKey(category_1));
        Product actualProduct_1 = inventoryService.getProducts().get(category_1).getFirst();
        assertTrue(compareProduct(baseProduct_1, actualProduct_1), "Ожидаемый и актуальный товары не равны");
        assertFalse(inventoryService.getProducts().containsKey(category_2));
    }

    @Test
    public void userCanNotAddNullProduct() {
        inventoryService.setInventoryOpen(true);
        assertThrows(IllegalArgumentException.class, () -> inventoryService.addProduct(null), "При добавлении товара=null не было исключения IllegalArgumentException");
        assertEquals(0, inventoryService.getProducts().size());
    }
}
