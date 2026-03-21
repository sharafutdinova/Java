package Task_2;

public class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    double getPrice() {
        return this.price;
    }

    void setPrice(double newPrice) {
        this.price = newPrice;
    }

    void applyDiscount(int discount) {
        this.price = this.price - this.price / 100 * discount;
    }

    void printInfo() {
        System.out.println("Product name " + this.name + " price " + this.price);
    }
}
