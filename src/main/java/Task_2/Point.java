package Task_2;

public class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return this.x;
    }

    void setX(int newX) {
        this.x = newX;
    }

    void print() {
        System.out.println("X = " + this.x + " Y = " + this.y);
    }
}
