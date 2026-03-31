package practice_10.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    //    public static final AtomicInteger count = new AtomicInteger(0);
    public static int count = 0;

    public static void increment() {
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
//                count.incrementAndGet();
                increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
//                count.incrementAndGet();
                increment();
            }
        });
        t1.start();
        t2.start();
        t2.join();
        t1.join();

//        System.out.println(count.get());
        System.out.println(count);
    }
};
