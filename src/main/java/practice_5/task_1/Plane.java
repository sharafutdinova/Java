package practice_5.task_1;

public class Plane extends Transport {
    public Plane() {
        super(200, 40000);
    }

    @Override
    public void start() {
        System.out.println("Plane is started");
    }
}
