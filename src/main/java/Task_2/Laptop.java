package Task_2;

public class Laptop {
    String brand;
    double price;

    Laptop(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    String getBrand() {
        return this.brand;
    }

    double getPrice() {
        return this.price;
    }

    void setPrice(double newPrice) {
        this.price = newPrice;
    }

    void setBrand(String newBrand) {
        this.brand = newBrand;
    }

    void printInfo() {
        System.out.println("Brand " + this.brand + " price " + this.price + ".руб ");
    }
}
