package Task_2;

public class Circle {
    int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    int getRadius() {
        return this.radius;
    }

    void setRadius(int newRadius) {
        this.radius = newRadius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }

    double calculateCircumference() {
        return Math.PI * 2 * radius;
    }
}
