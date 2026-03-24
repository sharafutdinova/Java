package practice_5.task_1;

public class Dispather {
    public void control(Transport transport) {
        transport.start();
    }

    public void printTransportDetails(Transport transport) {
        System.out.println("Speed " + transport.getSpeed());
        System.out.println("Capacity " + transport.getCapacity());
    }
}
