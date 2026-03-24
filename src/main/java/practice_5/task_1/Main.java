package practice_5.task_1;

public class Main {
    public static void main(String[] args) {
        Transport car = new Car();
        Transport ship = new Ship();
        Transport plane = new Plane();

        Dispather disp = new Dispather();

        disp.control(car);
        disp.control(ship);
        disp.control(plane);
        disp.printTransportDetails(car);
    }
}
