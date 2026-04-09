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
        return Map.copyOf(products);
    }

    public void addProduct(Product product) {
        if (product == null) throw new IllegalArgumentException("Продукт не может быть null");
        if (!isInventoryOpen) throw new StockClosedException("Склад закрыт");
        List<Product> categoryProducts;
        String category = product.getCategory();
        if (products.containsKey(category)) {
            categoryProducts = products.get(category);
        } else categoryProducts = new ArrayList<>();
        categoryProducts.add(product);
        products.put(category, categoryProducts);
    }

    public Product getProduct(String category) throws OutOfStockException {
        if (category == null || category.isEmpty())
            throw new IllegalArgumentException("Категория не может быть null или пустой");
        if (!isInventoryOpen) throw new StockClosedException("Склад закрыт");
        if (!products.containsKey(category))
            throw new OutOfStockException("Товаров категории " + category + " нет на складе");
        List<Product> categoryProducts = products.get(category);
        if (categoryProducts.isEmpty())
            throw new OutOfStockException("Товары категории " + category + " закончились на складе");
        Product product = categoryProducts.removeFirst();
        products.put(category, categoryProducts);
        return product;
    }

    public List<Product> filterProductsByPriceInCategory(String category, Double min, Double max) throws OutOfStockException {
        if (category == null || category.isEmpty())
            throw new IllegalArgumentException("Категория не может быть null или пустой");
        if (min > max) throw new IllegalArgumentException("Min значение не может быть больше max");
        if (!isInventoryOpen) throw new StockClosedException("Склад закрыт");
        if (!products.containsKey(category))
            throw new OutOfStockException("Товаров категории " + category + " нет на складе");
        List<Product> categoryProducts = products.get(category);
        if (categoryProducts.isEmpty())
            throw new OutOfStockException("Товары категории " + category + " закончились на складе");
        else {
            return categoryProducts.stream().filter(p -> p.getPrice() >= min && p.getPrice() <= max).toList();
        }
    }
}
