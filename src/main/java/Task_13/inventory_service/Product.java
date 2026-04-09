package Task_13.inventory_service;

import java.util.Objects;

public class Product {
    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Название не может быть null или пустым");
        if (category == null || category.isEmpty())
            throw new IllegalArgumentException("Категория не может быть null или пустым");
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 && Objects.equals(name, product.name) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, category);
    }
}
