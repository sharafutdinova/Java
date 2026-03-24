package practice_5.task_1;

public class Car extends Transport {
    public Car() {
        super(40, 100);
    }

    @Override
    public void start() {
        System.out.println("Car is started");
    }
}
