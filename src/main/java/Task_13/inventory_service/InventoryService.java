package Task_13.inventory_service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryService {
    private Map<String, List<Product>> products;
    private boolean isInventoryOpen = true;

    public InventoryService() {
        this.products = new HashMap<>();
    }

    public boolean isInventoryOpen() {
        return isInventoryOpen;
    }

    public void setInventoryOpen(boolean inventoryOpen) {
        isInventoryOpen = inventoryOpen;
    }

    public Map<String, List<Product>> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        if (isInventoryOpen) {
            List<Product> categoryProducts;
            String category = product.getCategory();
            if (products.containsKey(category)) {
                categoryProducts = products.get(category);
            } else categoryProducts = new ArrayList<>();
            categoryProducts.add(product);
            products.put(category, categoryProducts);
        } else throw new StockClosedException("Склад закрыт");
    }

    public Product getProduct(String category) throws OutOfStockException {
        if (isInventoryOpen) {
            if (products.containsKey(category)) {
                List<Product> categoryProducts = products.get(category);
                if (categoryProducts.isEmpty())
                    throw new OutOfStockException("Товары категории " + category + " закончились на складе");
                else {
                    Product product = categoryProducts.removeFirst();
                    products.put(category, categoryProducts);
                    return product;
                }
            } else throw new OutOfStockException("Товаров категории " + category + " нет на складе");
        } else {
            throw new StockClosedException("Склад закрыт");
        }
    }

    public List<Product> filterProductsByPriceInCategory(String category, Double min, Double max) throws OutOfStockException {
        if (isInventoryOpen) {
            if (min <= max) {
                if (products.containsKey(category)) {
                    List<Product> categoryProducts = products.get(category);
                    if (categoryProducts.isEmpty())
                        throw new OutOfStockException("Товары категории " + category + " закончились на складе");
                    else {
                        return categoryProducts.stream().filter(p -> p.getPrice() >= min && p.getPrice() <= max).toList();
                    }
                } else throw new OutOfStockException("Товаров категории " + category + " нет на складе");
            } else {
                throw new IllegalArgumentException("Min значение не может быть больше max");
            }
        } else {
            throw new StockClosedException("Склад закрыт");
        }
    }
}
