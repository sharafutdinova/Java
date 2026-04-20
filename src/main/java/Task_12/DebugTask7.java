package Task_12;

import java.util.concurrent.atomic.AtomicInteger;

public class DebugTask7 {
    private static AtomicInteger balance = new AtomicInteger(100);

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> withdraw(60));
        Thread t2 = new Thread(() -> withdraw(50));
        t1.start();
        t2.start();
    }

    public synchronized static void withdraw(int amount) {
        if (balance.get() >= amount) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            balance.addAndGet(-amount);
            System.out.println("New balance: " + balance.get());
        }
    }
}
