package practice_10.volatil;

public class Main {
    static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        StatusChecker statusChecker = new StatusChecker();
        Thread t1 = new Thread(statusChecker);
        t1.start();
        Thread.sleep(1000);
        statusChecker.stop();
        Thread t2 = new Thread(statusChecker::stop);
        t2.start();
        t1.join();
        t2.join();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
