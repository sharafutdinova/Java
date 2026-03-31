package Task_10.part_4;

public class Counter {
    private int counter = 0;

    public synchronized void increment() {
        counter++;
    }

    public int getCounter() {
        return this.counter;
    }
}
